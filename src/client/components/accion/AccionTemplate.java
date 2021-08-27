package client.components.accion;

import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class AccionTemplate extends JPanel {


    // Declaración de servicios y objetos
    private AccionComponent accionComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    // Declaración Objetos Gráficos
    private JLabel lImagen, lTitulo, lParrafo;

    // Declaración Objetos Decoradores
    private ImageIcon iDimAux;

    // Constructor
    public AccionTemplate(AccionComponent accionComponent,ImageIcon imagen,String titulo,String parrafo) {

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.accionComponent = accionComponent;
        this.accionComponent.getClass();


        //Imagen
        iDimAux = new ImageIcon(
                imagen.getImage()
                        .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        this.lImagen = sObjGraficos.construirJLabel(
                null,
                (250 - 60) / 2, 5, 45, 45,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.add(lImagen);

        //Titulo
        this.lTitulo = sObjGraficos.construirJLabel(
                titulo,
                (250 - 230) / 2, 50, 220, 30,
                null, null,
                sRecursos.getfPrincipal(),
                null,
                sRecursos.getColorPrincipal(),
                null,
                "c"
        );
        this.add(lTitulo);

        //Parrafo

        this.lParrafo = sObjGraficos.construirJLabel(
                "<html><div align='center'>" + parrafo + "</div></html>",
                (250 - 230) / 2, 75, 230, 50,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        this.add(lParrafo);


        this.setSize(250, 125);
        this.setBackground(Color.white);
        this.setBorder(sRecursos.getBorderGris());
        this.setLayout(null);
        this.setVisible(true);

    }



}
