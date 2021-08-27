package client.components.Tarjeta;

import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class TarjetaTemplate extends JPanel {

    // Declaración Servicios y dependencias
    private TarjetaComponent tarjetaComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    // Declaración Objetos Gráficos
    private JLabel lTitulo, lImagen, lParrafo;

    // Declaración Objetos Decoradores
    private ImageIcon iDimAux;


    public TarjetaTemplate(TarjetaComponent tarjetaComponent,ImageIcon iImagen){
        this.tarjetaComponent = tarjetaComponent;
        sObjGraficos= ObjGraficosService.getService();
        sRecursos =RecursosService.getService();

        this.tarjetaComponent = tarjetaComponent;
        this.tarjetaComponent.getClass();
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();



        iDimAux = new ImageIcon(
                iImagen.getImage()
                        .getScaledInstance(805, 225, Image.SCALE_AREA_AVERAGING)
        );
        lImagen = sObjGraficos.construirJLabel(
                null,
                5, 5, 805, 225,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.add(lImagen);


        this.setSize(805, 225);
        this.setBackground(Color.gray);
        this.setLayout(null);
        this.setVisible(true);

    }





}
