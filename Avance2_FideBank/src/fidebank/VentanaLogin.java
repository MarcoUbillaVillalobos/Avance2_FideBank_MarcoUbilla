package fidebank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame {
    private SistemaBanco sistema;
    private JTextField campoCedula;
    private JPasswordField campoPin;

    public VentanaLogin(SistemaBanco sistema) {
        this.sistema = sistema;
        setTitle("Ingresar a FideBank ");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        campoCedula = new JTextField();
        campoPin = new JPasswordField();

        add(new JLabel("Cédula:"));
        add(campoCedula);
        add(new JLabel("PIN:"));
        add(campoPin);

        JButton botonIngresar = new JButton("Ingresar");
        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = campoCedula.getText();
                String pin = new String(campoPin.getPassword());
                Cliente cliente = sistema.autenticar(cedula, pin);
                if (cliente != null) {
                    dispose(); // Cierra ventana de login
                    new VentanaMenu(cliente);
                } else {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, la identificación o la contraseña que digito anteriormente fueron incorrectos.");
                }
            }
        });

        add(botonIngresar);
        setVisible(true);
    }
}
