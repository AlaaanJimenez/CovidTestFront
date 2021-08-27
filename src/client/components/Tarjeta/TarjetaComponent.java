package client.components.Tarjeta;

import javax.swing.*;

public class TarjetaComponent {

    private TarjetaTemplate tarjetaTemplate;


    public TarjetaComponent( ImageIcon iImagen) {
        tarjetaTemplate = new TarjetaTemplate(this,  iImagen);
    }

    public TarjetaTemplate getTarjetaTemplate() {
        return tarjetaTemplate;
    }
}