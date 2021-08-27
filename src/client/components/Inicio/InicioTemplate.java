package client.components.Inicio;

import client.components.Tarjeta.TarjetaComponent;
import client.components.accion.AccionComponent;
import client.components.accion.AccionTemplate;
import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class InicioTemplate extends JPanel {
    private static final long serialVersionUID = 1L;

    private String USER_PATH, IMAGE_PATH;

    // Declaración Servicios y dependencias
    private InicioComponent inicioComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    // Declaración Objetos Gráficos
    private JPanel pMision, pVision, pNosotros, pAcciones,lTitulo, lImagen;
    private JLabel lAcciones;

    // Declaración Objetos Decoradores
    private ImageIcon iTarjeta1, iTarjeta2, iTarjeta3;
    private ImageIcon iClase, iPantalla, iIdea, iCelular, iEstadistica, iDireccion;

    public InicioTemplate(InicioComponent inicioComponent)
    {
        this.USER_PATH=System.getProperty("user.dir");

        this.inicioComponent = inicioComponent;
        this.inicioComponent.getClass();
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearContenidoPMision();
        this.crearContenidoPAcciones();


        this.setSize(850, 600);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void crearJPanels(){
        this.pMision = sObjGraficos.construirJPanel(20, 15, 810, 230, Color.gray, null);
        this.add(pMision);


        this.pAcciones = sObjGraficos.construirJPanel(20, 260, 810, 330, Color.gray, null);
        this.add(pAcciones);
    }
    public void crearObjetosDecoradores(){
    this.iTarjeta1 = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\tarjetas\\tarjeta1.jpg");
    this.iTarjeta2 = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\tarjetas\\tarjeta2.jpg");
    this.iTarjeta3 = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\tarjetas\\tarjeta3.jpg");
    this.iClase = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\accion\\clases.png");
    this.iPantalla = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\accion\\pantalla.png");
    this.iCelular = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\accion\\celular.png");
    this.iIdea = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\accion\\ideas.png");
    this.iEstadistica = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\accion\\estadisticas.png");
    this.iDireccion = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\accion\\direccion.png");
    }

    public void crearContenidoPMision() {
        this.pMision.add(
                new TarjetaComponent(
                        iTarjeta1
                ).getTarjetaTemplate()
        );
    }
    public void crearContenidoPAcciones(){
        this.lAcciones = sObjGraficos.construirJLabel(
                "Nuestros Servicios",
                10, 10, 180, 30,
                null, null,
                sRecursos.getfPrincipal(),
                null,
                Color.white,
                null,
                "c"
        );
        this.pAcciones.add(lAcciones);

        // COMPONENTE ACCIÓN 1 ------------------------------------
        AccionTemplate p1 = new AccionComponent(
                iClase,
                "Turnos",
                "Generar turno para testeo de Covid-19"
        ).getAccionTemplate();
        p1.setLocation(15, 50);
        this.pAcciones.add(p1);

        // COMPONENTE ACCIÓN 2 ------------------------------------
        AccionTemplate p2 = new AccionComponent(
                iPantalla,
                "Informacion",
                "Informacion sobre medidas preventivas."
        ).getAccionTemplate();
        p2.setLocation(30 + p2.getWidth(), 50);
        this.pAcciones.add(p2);

// COMPONENTE ACCIÓN 3 ------------------------------------
        AccionTemplate p3 = new AccionComponent(
                iIdea,
                "Generación de ideas",
                "Desarrollo de ideas con tecnologías actuales."
        ).getAccionTemplate();
        p3.setLocation(45 + p3.getWidth() * 2, 50);
        this.pAcciones.add(p3);

// COMPONENTE ACCIÓN 4 ------------------------------------
        AccionTemplate p4 = new AccionComponent(
                iCelular,
                "Notificaciones",
                "Notificaciónes sobre ek estado de tus Testeos y actividades."
        ).getAccionTemplate();
        p4.setLocation(15, 65 + p4.getHeight());
        this.pAcciones.add(p4);

// COMPONENTE ACCIÓN 5 ------------------------------------
        AccionTemplate p5 = new AccionComponent(
                iEstadistica,
                "Estadisticas",
                "Estadisticas de resultados de Testeos."
        ).getAccionTemplate();
        p5.setLocation(30 + p5.getWidth(), 65 + p5.getHeight());
        this.pAcciones.add(p5);

// COMPONENTE ACCIÓN 6 ------------------------------------
        AccionTemplate p6 = new AccionComponent(
                iDireccion,
                "Direcciónes",
                "Direcciones de centros de testeo de Covid-19"
        ).getAccionTemplate();
        p6.setLocation(45 + p6.getWidth() * 2, 65 + p6.getHeight());
        this.pAcciones.add(p6);

    }





}
