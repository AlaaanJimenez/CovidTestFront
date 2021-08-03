package services;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RecursosService {

    private String USER_PATH,IMAGE_PATH,BACKGROUND2_PATH;
    private Color colorPrincipal, colorGrisOscuro,colorSecundario;
    private Font fTitulo;
    private Cursor cGeneral;
    private Border bInferiorTitulo,bInferiormate;
    private ImageIcon iFondo, iCerrar,iFondo2,iUsuario,iClave,iDimAux,iGithub,iFacebook,iLogo;
    static private RecursosService servicio;


    private RecursosService() {
        this.USER_PATH=System.getProperty("user.dir");

        generarFuentes();

        this.crearColores();
        this.crearFuentes();
        this.crearCursores();
        this.crearBordes();
        this.crearImagenes();
    }

    private void crearColores() {
        colorPrincipal = new Color(60,78,120);
        colorGrisOscuro = new Color(80, 80, 80);
        colorSecundario = new Color(151, 0, 158);

    }

    private void crearFuentes() {
        fTitulo=new Font("Swing",Font.PLAIN,30);
    }

    private void crearCursores() { cGeneral=new Cursor(Cursor.HAND_CURSOR);}

    private void crearBordes() {
        bInferiormate= BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        bInferiorTitulo = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue);
    }

    private void crearImagenes() {
        iFondo=new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\background2.jpg");
        iFondo2=new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\background.jpg");
        iClave=new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\clave.png");
        iUsuario=new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\usuario.png");
        iGithub=new ImageIcon(("" + USER_PATH + "\\resourses\\imagenes\\github.jpg"));
        iFacebook=new ImageIcon(("" + USER_PATH + "\\resourses\\imagenes\\facebook.png"));
        iCerrar=new ImageIcon("" + USER_PATH + "\\resourses\\imagenes\\cerrar.png");

    }

    private void generarFuentes() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont( Font.createFont(
                    Font.TRUETYPE_FONT,
                    new File("" + USER_PATH + "\\resourses\\fuentes\\swingregular.ttf")
            ));
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
    }


    ///GETTERS---------------------------------------------------------------------------------------------------------------
    public Color getColorPrincipal() { return colorPrincipal; }
    public Color getColorGrisOscuro() { return colorGrisOscuro; }
    public Color getColorSecundario(){ return colorSecundario; }
    public Font getFontTitulo() { return fTitulo; }

    public Border getbInferiormate() {
        return bInferiormate;
    }

    //public Font getFontTPrincipal() { return fTitulo; }
    //public Font getFontSubtitulo() { return fontSubtitulo; }
    //public Font getFontMediana() { return fontMediana; }
    public Cursor getCMano() { return cGeneral; }
    public Border getBInferiorTitulo() { return bInferiorTitulo; }
    public ImageIcon getiFondo() {
        return iFondo;
    }
    public ImageIcon getiCerrar() {
        return iCerrar;
    }
    public ImageIcon getiLogo() {
        return iLogo;
    }
    public ImageIcon getiFondo2() {
        return iFondo2;
    }
    public ImageIcon getiUsuario() {
        return iUsuario;
    }
    public ImageIcon getiClave() {
        return iClave;
    }
    public ImageIcon getiDimAux() {
        return iDimAux;
    }
    public ImageIcon getiGithub() {
        return iGithub;
    }
    public ImageIcon getiFacebook() {
        return iFacebook;
    }


    public static RecursosService getService() {
        if (servicio == null) servicio = new RecursosService();
        return servicio;
    }
}