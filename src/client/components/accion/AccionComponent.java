package client.components.accion;

import javax.swing.*;

public class AccionComponent {

    private AccionTemplate accionTemplate;



    public AccionComponent(ImageIcon imagen, String titulo, String parrafo) {
        this.accionTemplate= new AccionTemplate(this, imagen, titulo, parrafo);
    }



    public AccionTemplate getAccionTemplate(){
        return accionTemplate;
    }





}
