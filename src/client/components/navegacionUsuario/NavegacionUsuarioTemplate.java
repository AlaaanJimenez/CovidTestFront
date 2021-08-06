package client.components.navegacionUsuario;

import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NavegacionUsuarioTemplate extends JPanel {

    private static final long serialVersionUID = 1L;
    private String USER_PATH, IMAGE_PATH, BACKGROUND2_PATH;

    // Declaración Servicios y dependencias
    private NavegacionUsuarioComponent navegacionUsuarioComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    // Declaración objetos gráficos
    private JPanel pSuperior, pInferior;
    private JLabel lNombreUsuario, lEslogan, lImagenUsuario, lIconoUsuario;
    private JButton bInicio, bPerfil, bAmigos, bProductos, bConfiguracion, bCerrarSesion;

    // Declaración Objetos Decoradores
    private ImageIcon iIconoUsuario, iInicio, iPerfil, iAmigos, iProductos,iConfiguracion, iCerrarSesion, iImagenUsuario, iDimAux;
    private Border bVacio;

    public NavegacionUsuarioTemplate(NavegacionUsuarioComponent navegacionUsuarioComponent){

        this.USER_PATH=System.getProperty("user.dir");

        this.navegacionUsuarioComponent = navegacionUsuarioComponent;
        this.sObjGraficos= ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJLabels();
        this.crearJButtons();

        this.setSize(250, 700);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJPanels(){
        this.pSuperior = sObjGraficos.construirJPanel(
                0, 0, 250, 300,
                sRecursos.getColorPrincipal(),
                null
        );
        this.add(pSuperior);

        this.pInferior = sObjGraficos.construirJPanel(
                0, 300, 250, 400,
                sRecursos.getColorPrincipal(),
                null
        );
        this.add(pInferior);
    }

    public void crearObjetosDecoradores(){
        this.iIconoUsuario = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\usuario_navegacion.png");
        this.iInicio = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\inicio.png.png");
        this.iPerfil = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\perfil.png");
        this.iAmigos = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\amigos.png");
        this.iProductos = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\productos.png");
        this.iConfiguracion = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\configuracion.png");
        this.iCerrarSesion = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\salir.png");
        this.iImagenUsuario = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\perfiles\\perfil1.png");
        this.bVacio = new EmptyBorder(2, 20, 2, 2);
    }

    public void crearJButtons(){
        // BOTÓN INICIO--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iInicio.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        this.bInicio = sObjGraficos.construirJButton(
                "      Inicio",
                30, 30, 200, 40,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bInicio.addActionListener(navegacionUsuarioComponent);
        this.pInferior.add(bInicio);

        // BOTÓN PERFIL--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iPerfil.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        this.bPerfil = sObjGraficos.construirJButton(
                "      Perfil",
                30, 80, 200, 40,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bPerfil.addActionListener(navegacionUsuarioComponent);
        this.pInferior.add(bPerfil);

        // BOTÓN AMIGOS--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iAmigos.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        this.bAmigos = sObjGraficos.construirJButton(
                "      Amigos",
                30, 130, 200, 40,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bAmigos.addActionListener(navegacionUsuarioComponent);
        this.pInferior.add(bAmigos);

        // BOTÓN PRODUCTOS--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iProductos.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        this.bProductos = sObjGraficos.construirJButton(
                "      Productos",
                30, 180, 200, 40,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bProductos.addActionListener(navegacionUsuarioComponent);
        this.pInferior.add(bProductos);

        // BOTÓN CONFIGURACIÓN--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iConfiguracion.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        this.bConfiguracion = sObjGraficos.construirJButton(
                "      Configuraciones",
                30, 230, 200, 40,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bConfiguracion.addActionListener(navegacionUsuarioComponent);
        this.pInferior.add(bConfiguracion);

        // BOTÓN CERRAR SESIÓN--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iCerrarSesion.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        this.bCerrarSesion = sObjGraficos.construirJButton(
                "      Cerrar Sesión",
                30, 280, 200, 40,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bCerrarSesion.addActionListener(navegacionUsuarioComponent);
        this.pInferior.add(bCerrarSesion);
    }

    public void crearJLabels(){
        // LABEL ICONO USUARIO--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iIconoUsuario.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.lIconoUsuario = sObjGraficos.construirJLabel(
                null,
                10, 20, 40, 40,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.pSuperior.add(lIconoUsuario);

        // LABEL NOMBRE USUARIO--------------------------------------------------------------------
        this.lNombreUsuario = sObjGraficos.construirJLabel(
                "Nombre de Usuario",
                ((this.pSuperior.getWidth() - 200) / 2) + 10, 20, 200, 40,
                null, null,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        this.pSuperior.add(lNombreUsuario);

        // LABEL IMAGEN USUARIO--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iImagenUsuario.getImage()
                        .getScaledInstance(180, 180, Image.SCALE_AREA_AVERAGING)
        );
        this.lImagenUsuario = sObjGraficos.construirJLabel(
                null,
                (this.pSuperior.getWidth() - 180) / 2, 75, 180, 180,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.pSuperior.add(lImagenUsuario);

        // LABEL ESLOGAN--------------------------------------------------------------------
        //se usan etiquetas HTML para poder dar saltos de linea al texto y ademas brindar de varias otras características
        this.lEslogan = sObjGraficos.construirJLabel(
                "<html><div align='center'> Nuestros clientes son <br/>lo mas importante</div></html>",
                (this.pSuperior.getWidth() - 180) / 2, 265, 180, 40,
                null, null,
                sRecursos.getFontLigera(),
                null,
                Color.WHITE,
                null,
                "c");
        this.pSuperior.add(lEslogan);
    }

}
