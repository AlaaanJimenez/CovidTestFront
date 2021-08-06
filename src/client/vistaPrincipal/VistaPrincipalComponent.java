package client.vistaPrincipal;

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

    public VistaPrincipalComponent(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;
        this.vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
        this.barraTituloComponent = new BarraTituloComponent(this);
       // this.navegacionUsuarioComponent = new NavegacionUsuarioComponent(this);


        vistaPrincipalTemplate.getPBarra()
                .add(barraTituloComponent.getBarraTituloTemplate());

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

        vistaPrincipalTemplate.repaint();
    }
}
