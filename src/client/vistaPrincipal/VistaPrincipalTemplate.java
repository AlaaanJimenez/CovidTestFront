package com.company.vistaPrincipal;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VistaPrincipalTemplate extends JFrame {

public VistaPrincipalTemplate()
{
    super("Vista Principal");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1200, 700);
    setLocationRelativeTo(this);
    setLayout(null);
    // setUndecorated(true);
    // getContentPane().setBackground(Color.WHITE);
    setVisible(true);
}

}
