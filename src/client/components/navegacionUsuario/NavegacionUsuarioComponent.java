package client.components.navegacionUsuario;

import client.components.barraTitulo.BarraTituloTemplate;
import client.vistaPrincipal.VistaPrincipalComponent;
import services.RecursosService;

import javax.swing.*;
import java.awt.event.*;

public class NavegacionUsuarioComponent extends MouseAdapter implements ActionListener {

    private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    public NavegacionUsuarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.navegacionUsuarioTemplate = new NavegacionUsuarioTemplate(this);

    }





    public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
        return this.navegacionUsuarioTemplate;
    }

//ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        //Muestra en consola los strings asignados a cada boton
        System.out.println(e.getActionCommand().trim());
        this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
    }

//MouseListener interface
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        //Modifica el color de los botones de navegacion al posicionarse sobre ellos
        //Se obtiene el objeto gráfico que ha activado el evento, esto mediante el método getSource.
        JButton boton = ((JButton) e.getSource());
        boton.setContentAreaFilled(true);
        boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());

        }

    public void mouseExited(MouseEvent e) {
        //Quita el resaltado de los botones cuando el mouse no esta sobre ellos
        JButton boton = ((JButton) e.getSource());
        boton.setContentAreaFilled(false);

    }


}