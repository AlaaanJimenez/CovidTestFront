package client.components.barraTitulo;

import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class BarraTituloTemplate extends JPanel {
    private static final long serialVersionUID = 1L;
    private String USER_PATH, IMAGE_PATH, BACKGROUND2_PATH;

    // Declaración Servicios y dependencias
    private BarraTituloComponent barraTituloComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    // Declaración objetos gráficos
    private JLabel lLogoApp, lTituloApp;
    private JButton bCerrar, bMinimizar;

    // Declaración Objetos Decoradores
    private ImageIcon iLogoApp, iDimAux;
    private Font fontTituloBarra;

    public BarraTituloTemplate(BarraTituloComponent barraTituloComponent) {

        this.USER_PATH=System.getProperty("user.dir");


        this.barraTituloComponent = barraTituloComponent;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.addMouseListener(barraTituloComponent);
        this.addMouseMotionListener(barraTituloComponent);

        this.crearObjetosDecoradores();
        this.crearJLabels();
        this.crearJButtons();

        this.setSize(850, 50);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.addMouseListener(barraTituloComponent);
        this.addMouseMotionListener(barraTituloComponent);
        this.setVisible(true);
    }

    public void crearObjetosDecoradores() {
        iLogoApp = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\logo.png");
        fontTituloBarra = new Font("Britannic Bold", Font.PLAIN, 24);
    }

    public void crearJButtons() {
        iDimAux = new ImageIcon(
                sRecursos.getiCerrar().getImage()
                        .getScaledInstance(23, 23, Image.SCALE_AREA_AVERAGING)
        );
        bCerrar = sObjGraficos.construirJButton(
                null,
                800, 10, 45, 30,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c",
                false
        );
        bCerrar.addActionListener(barraTituloComponent);
        this.add(bCerrar);

        iDimAux = new ImageIcon(
                sRecursos.getIMinimizar().getImage()
                        .getScaledInstance(28, 28, Image.SCALE_AREA_AVERAGING)
        );
        bMinimizar = sObjGraficos.construirJButton(
                null,
                750, 10, 45, 30,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c",
                false
        );
        bMinimizar.addActionListener(barraTituloComponent);
        this.add(bMinimizar);
    }

    public void crearJLabels() {
        iDimAux = new ImageIcon(
                iLogoApp.getImage()
                        .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)
        );
        lLogoApp = sObjGraficos.construirJLabel(
                null,
                20, 0, 50, 50,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.add(lLogoApp);

        lTituloApp = sObjGraficos.construirJLabel(
                "Covid Test Mannager",
                50, 5, 350, 40,
                null, null,
                fontTituloBarra,
                null,
                sRecursos.getColorPrincipal(),
                null,
                "c"
        );
        this.add(lTituloApp);
    }

    public JButton getBCerrar() { return bCerrar; }

    public JButton getBMinimizar() { return bMinimizar; }
}
