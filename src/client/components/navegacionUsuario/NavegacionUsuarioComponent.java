package client.components.navegacionUsuario;

import client.components.barraTitulo.BarraTituloTemplate;
import client.vistaPrincipal.VistaPrincipalComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavegacionUsuarioComponent implements ActionListener {

    private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    public NavegacionUsuarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.navegacionUsuarioTemplate = new NavegacionUsuarioTemplate(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Muestra en consola los strings asignados a cada boton
        System.out.println(e.getActionCommand().trim());
        this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
    }


    public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
        return this.navegacionUsuarioTemplate;
    }
}