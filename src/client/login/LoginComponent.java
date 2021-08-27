package client.login;

import client.vistaPrincipal.VistaPrincipalComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginComponent implements ActionListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipal;

    public LoginComponent() {
        this.loginTemplate = new LoginTemplate(this);
    }


//ActionListener-------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== loginTemplate.getbCerrar()){
            System.exit(0);
        }
        if (e.getSource() == loginTemplate.getbEntrar()) {
            this.mostrarDatosUsuario();
            this.entrar();
        }
        if(e.getSource()== loginTemplate.getbRegistrarse()){
            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
        }

    }


//METODOS-------------------------------------------------------------------

    public void mostrarDatosUsuario() {
        String nombreUsuario = loginTemplate.getTNombreUsuario().getText();
        String claveUsuario = new String(loginTemplate.getTClaveUsuario().getPassword());
        String tipoUsuario = ((String) loginTemplate.getCbTipoUsuario().getSelectedItem());

        JOptionPane.showMessageDialog(
                null,
                "Nombre Usuario: " + nombreUsuario +
                        "\n Clave Usuario: " + claveUsuario +
                        "\nTipo Usuario: " + tipoUsuario ,
                "Advertencia",
                1
        );
    }
    public void entrar() {
        /*Se realiza comprobacion para evitar la creacion de mas de 1 componente de la
            clase vistaPrincipal e pregunta si el objeto de la clase VistaPrincipalComponent no se ha ejemplificado, si aun
            no se ha entrado a la vista principal este objeto efectivamente estará vacío ya que no se ha ejemplificado antes.*/
        if (vistaPrincipal == null)
            this.vistaPrincipal = new VistaPrincipalComponent(this);
        else
            this.vistaPrincipal.getVistaPrincipalTemplate().setVisible(true);
        loginTemplate.setVisible(false);
    }
    public LoginTemplate getLoginTemplate() {
        return this.loginTemplate;
    }








}
