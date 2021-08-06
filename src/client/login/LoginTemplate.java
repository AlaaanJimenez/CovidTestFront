package client.login;

import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoginTemplate extends JFrame {

    private String USER_PATH, IMAGE_PATH, BACKGROUND2_PATH;


    //Declaracion objetos Graficos
    private JPanel pDerecha, pIzquierda;
    private JLabel lTituloApp, lEslogan, lTituloLogin, lNotificaciones, lFondo, lFondo2, lUsuario, lClave, lGithub, lFacebook;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    private JComboBox<String> cbTipoUsuario;
    private JButton bEntrar, bCerrar, bRegistrarse, bOpcion1, bOpcion2, bOpcion3;
    private JCheckBox checkSi, checkNo;
    private ButtonGroup grupo;

    //Declaracion objetos decoradores
    private ImageIcon iFondo, iLogo, iFondo2, iUsuario, iClave, iDimAux, iGithub, iFacebook;

    // Declaración servicios
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private LoginComponent loginComponent;

    public LoginTemplate(LoginComponent loginComponent) {
        this.USER_PATH=System.getProperty("user.dir");

        this.loginComponent = loginComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();


        //Paneles
        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJComboBoxes();
        this.crearJButtons();
        //this.crearJCheckBoxes();
        this.crearJLabels();


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }




    //FRONT
    public void crearObjetosDecoradores() {
        iFondo = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\background2.jpg");
        iFondo2 = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\background.jpg");
        iClave = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\clave.png");
        iUsuario = new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\usuario.png");
        iGithub = new ImageIcon(("" + USER_PATH + "\\resourses\\imagenes\\github.jpg"));
        iFacebook = new ImageIcon(("" + USER_PATH + "\\resourses\\imagenes\\facebook.png"));
    }
    public void crearJPanels() {
        pIzquierda = sObjGraficos.construirJPanel(0, 0, 600, 500, Color.WHITE, null);
        this.add(pIzquierda);

        pDerecha = sObjGraficos.construirJPanel(600, 0, 400, 500, Color.WHITE, null);
        this.add(pDerecha);
    }
    public void crearJTextFields() {
        tNombreUsuario = sObjGraficos.construirJTextField(
                "Nombre Usuario",
                (pDerecha.getWidth() - 260) / 2, 185, 260, 40,
                null,
                Color.WHITE,
                sRecursos.getColorPrincipal(),
                sRecursos.getColorGrisOscuro(),
                sRecursos.getBInferiorTitulo(),
                "c"
        );
        pDerecha.add(tNombreUsuario);
    }
    public void crearJButtons() {

// BOTÓN ENTRAR-----------------------------------------------------------------------------
        bEntrar = sObjGraficos.construirJButton(
                "Sign in",
                (pDerecha.getWidth() - 250) / 2, 300, 250, 45,
                sRecursos.getCMano(),
                null, null,
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        bEntrar.addActionListener(loginComponent);
        pDerecha.add(bEntrar);


// BOTÓN REGISTRARSE-----------------------------------------------------------------------
        bRegistrarse = sObjGraficos.construirJButton(
                "Registrarse",
                250, 459, 145, 35,
                sRecursos.getCMano(),
                null, null,
                Color.black,
                Color.WHITE,
                sRecursos.getBInferiorTitulo(),
                "c",
                true
        );
        bRegistrarse.addActionListener(loginComponent);
        pDerecha.add(bRegistrarse);

// BOTÓN CERRAR-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiCerrar().getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        bCerrar = sObjGraficos.construirJButton(
                null,
                350, 10, 40, 40,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c",
                false
        );
        bCerrar.addActionListener(loginComponent);
        pDerecha.add(bCerrar);

    }
    public void crearJLabels(){

//LABEL TITULO APP-----------------------------------------------------------------------------
        lTituloApp = sObjGraficos.construirJLabel(
                "Covid Test Manager",
                125, 40, 350, 30,
                null, null,
                sRecursos.getFontTitulo(),
                null,
                Color.black,
                null,
                "c"
        );
        pIzquierda.add(lTituloApp);


// MODIFICAR  LABEL TITULO LOGIN Panel Derecho-----------------------------------------------------------------------------
        lTituloLogin = sObjGraficos.construirJLabel(
                "Inicio de sesion",
                (pDerecha.getWidth() - 300) / 2, 60, 300, 30,
                null, null,
                sRecursos.getFontTitulo(),
                null,
                Color.CYAN,
                null,
                "c"
        );
        pDerecha.add(lTituloLogin);


// LABEL Imagen USUARIO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iUsuario.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        lUsuario = sObjGraficos.construirJLabel(
                null,
                17, 183, 40, 40,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        pDerecha.add(lUsuario);


// LABEL CLAVE-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iClave.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        lClave = sObjGraficos.construirJLabel(
                null,
                17, 237, 40, 40,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        pDerecha.add(lClave);

// LABEL FACEBOOK-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iFacebook.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        lFacebook = sObjGraficos.construirJLabel(
                null,
                10, 450, 40, 40,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c"
        );
        pIzquierda.add(lFacebook);

// LABEL github-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iGithub.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        lGithub = sObjGraficos.construirJLabel(
                null,
                10, 405, 40, 40,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c"
        );
        pIzquierda.add(lGithub);


//Los labels que se declaran antes se posicionan sobre los labels que se declaran luego, por eso los fondos van ultimos

// LABEL Fondo Panel IZQUIERDO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(600, 300, Image.SCALE_AREA_AVERAGING)
        );
        lFondo = sObjGraficos.construirJLabel(
                null,
                0, 125, 600, 300,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        pIzquierda.add(lFondo);

// LABEL Fondo Panel DERECHO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iFondo2.getImage()
                        .getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING)
        );
        lFondo = sObjGraficos.construirJLabel(
                null,
                0, 0, 600, 600,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        pDerecha.add(lFondo);
       }
    public void crearJComboBoxes() {
        cbTipoUsuario = sObjGraficos.construirJComboBox(
                "Usuario_Administrador",
                (pDerecha.getWidth() - 220) / 2, 120, 220, 30,
                null,
                Color.WHITE,
                sRecursos.getColorPrincipal(),
                "c"
        );
        pDerecha.add(cbTipoUsuario);
    }
    public void crearJPasswordFields() {
        tClaveUsuario = sObjGraficos.construirJPasswordField(
                "Clave Usuario",
                (pDerecha.getWidth() - 260) / 2, 240, 260, 40,
                null, null,
                sRecursos.getColorPrincipal(),
                sRecursos.getColorGrisOscuro(),
                sRecursos.getBInferiorTitulo(),
                "c"
        );
        pDerecha.add(tClaveUsuario);
    }

//Getters


    public JComboBox<String> getCbTipoUsuario() {
        return cbTipoUsuario;
    }

    public JButton getbEntrar() {
        return bEntrar;
    }
    public JButton getbCerrar() {
        return bCerrar;
    }
    public JButton getbRegistrarse() {
        return bRegistrarse;
    }
    public JButton getbOpcion1() {
        return bOpcion1;
    }
    public JButton getbOpcion2() {
        return bOpcion2;
    }
    public JButton getbOpcion3() {
        return bOpcion3;
    }

    public JCheckBox getCheckSi() {
        return checkSi;
    }
    public JCheckBox getCheckNo() {
        return checkNo;
    }

    public JTextField getTNombreUsuario() { return this.tNombreUsuario; }
    public JPasswordField getTClaveUsuario() { return this.tClaveUsuario; }

    public ButtonGroup getGrupo() {
        return grupo;
    }
}