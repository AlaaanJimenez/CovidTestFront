package client.components.barraTitulo;

import client.vistaPrincipal.VistaPrincipalComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarraTituloComponent extends MouseAdapter implements ActionListener {

    private BarraTituloTemplate barraTituloTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private int posicionInicialX, posicionInicialY;


    public BarraTituloComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.barraTituloTemplate = new BarraTituloTemplate(this);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == barraTituloTemplate.getBMinimizar())
            vistaPrincipalComponent.minimizar();
        if (e.getSource() == barraTituloTemplate.getBCerrar())
            vistaPrincipalComponent.cerrar();
    }

    // MÉTODOS MOUSELISTENER
    @Override
    public void mousePressed(MouseEvent e) {
        posicionInicialX = e.getX()+250;
        posicionInicialY = e.getY();
    }


    // MÉTODOS MOUSEMOTIONLISTENER
    @Override
    public void mouseDragged(MouseEvent e) {
        this.vistaPrincipalComponent.moverVentana(
                e.getXOnScreen() - posicionInicialX,
                e.getYOnScreen() - posicionInicialY
        );
    }




    // Getters
    public BarraTituloTemplate getBarraTituloTemplate() {
        return this.barraTituloTemplate;
    }

}
