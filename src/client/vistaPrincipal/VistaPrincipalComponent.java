package client.vistaPrincipal;

import client.components.Inicio.InicioComponent;
import client.components.barraTitulo.BarraTituloComponent;
import client.components.navegacionUsuario.NavegacionUsuarioComponent;
import client.login.LoginComponent;

import java.awt.*;

public class VistaPrincipalComponent {

    private VistaPrincipalTemplate vistaPrincipalTemplate;

    //Declaración componentes
    private BarraTituloComponent barraTituloComponent;
    private NavegacionUsuarioComponent navegacionUsuarioComponent;
    private LoginComponent loginComponent;

    private InicioComponent inicioComponent;

    public VistaPrincipalComponent(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;
        this.vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
        this.barraTituloComponent = new BarraTituloComponent(this);
        this.navegacionUsuarioComponent = new NavegacionUsuarioComponent(this);


        this.inicioComponent = new InicioComponent();



        vistaPrincipalTemplate.getPBarra()
                .add(barraTituloComponent.getBarraTituloTemplate());

        vistaPrincipalTemplate.getPNavegacion().add(
                navegacionUsuarioComponent.getNavegacionUsuarioTemplate()
        );

        vistaPrincipalTemplate.getPPrincipal()
                .add(inicioComponent.getInicioTemplate());
    }


//METODOS


    public void cerrar() {
        System.exit(0);
    }

    public void minimizar() {
        this.vistaPrincipalTemplate.setExtendedState(Frame.ICONIFIED);
    }


    //Getters
    public VistaPrincipalTemplate getVistaPrincipalTemplate() {
        return this.vistaPrincipalTemplate;
    }

    public void mostrarComponente(String comando) {

    /*   Cada vez que se vuelva a llamar un nuevo componente para ser incorporado en el panel pPrincipal es necesario que antes de la incorporación
           se remueva lo que este panel contiene, para que esto sea posible se debe llamar al método removeAll().
           Esto debe hacerse justamente antes de que empiece el switch: */
    vistaPrincipalTemplate.getPPrincipal().removeAll();

        switch (comando) {
            /*De esta forma la primera vez que se oprima el botón inicio se creara el objeto en memoria y se incorporara en la ventana principal,
             pero cuando se vuelva a oprimir simplemente incorporará el objeto que previamente se ejemplifico. Ademas de controlar la cantidad de
             objetos también lo se crean solamente en caso de ser necesario y de esta forma se gana también en el rendimiento de la aplicación.*/
           /* case "Inicio":
                if (this.inicioComponent == null)
                    this.inicioComponent = new InicioComponent();
                vistaPrincipalTemplate.getPPrincipal().add(
                        inicioComponent.getInicioTemplate()
                );*/
            case "Inicio":
            vistaPrincipalTemplate.getPPrincipal()
                    .add(inicioComponent.getInicioTemplate());
            break;

            case "Perfil":
                break;
            case "Resultados Testeos":
                break;
            case "Configuraciones":
                break;
            case "Cerrar Sesión":
                this.loginComponent.getLoginTemplate().setVisible(true);
                this.vistaPrincipalTemplate.setVisible(false);
                break;
        }
        vistaPrincipalTemplate.repaint();

    }
}

