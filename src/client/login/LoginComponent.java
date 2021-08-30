package client.login;

import client.vistaPrincipal.VistaPrincipalComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginComponent extends MouseAdapter implements ActionListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipal;

    private String[] placeholders = { "Nombre Usuario", "Clave Usuario" };
    private JTextField text;
    private JButton boton;
    private JLabel label;

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


    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorPrincipalOscuro());
        }
    }

    @Override
    public void mouseExited (MouseEvent e){
            if (e.getSource() instanceof JButton) {
                boton = ((JButton) e.getSource());
                boton.setBackground(loginTemplate.getRecursosService().getColorPrincipal());
            }

        }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Al posicionarse sobre el Textfield  elimina el texto solo cuando es == a uno de los placeholders

            if (e.getSource() instanceof JTextField) {
                text = ((JTextField) e.getSource());
                if (text.getText().equals(placeholders[0]) ||text.getText().equals(placeholders[1]))
                    text.setText("");
            }
        }


}
