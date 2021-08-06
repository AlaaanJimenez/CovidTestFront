
package com.company;
import client.login.LoginComponent;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Runnable runApplication = new Runnable () {
            public void run(){
                //VistaPrincipalTemplate vista = new VistaPrincipalTemplate();
                LoginComponent vista = new LoginComponent();

            }
        };
        SwingUtilities.invokeLater(runApplication);

    }
}
