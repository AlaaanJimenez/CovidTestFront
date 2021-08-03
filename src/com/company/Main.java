package com.company;


import com.company.vistaPrincipal.VistaPrincipalTemplate;
import client.login.LoginTemplate;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Runnable runApplication = new Runnable () {
            public void run(){
                //VistaPrincipalTemplate vista = new VistaPrincipalTemplate();
                LoginTemplate vista = new LoginTemplate();
                vista.getClass();

            }
        };
        SwingUtilities.invokeLater(runApplication);

    }
}
