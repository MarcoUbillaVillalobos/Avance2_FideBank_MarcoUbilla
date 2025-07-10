package fidebank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaMenu extends JFrame {
    private Cliente cliente;

    public VentanaMenu(Cliente cliente) {
        this.cliente = cliente;
        setTitle("FideBank - Menú Principal");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JButton botonSaldo = new JButton("Consultar Saldo");
        JButton botonRetiro = new JButton("Retirar Dinero");
        JButton botonSalir = new JButton("Salir");

        botonSaldo.addActionListener(e -> consultarSaldo());
        botonRetiro.addActionListener(e -> retirarDinero());
        botonSalir.addActionListener(e -> System.exit(0));

        add(botonSaldo);
        add(botonRetiro);
        add(botonSalir);
        setVisible(true);
    }

    private void consultarSaldo() {
        CuentaBancaria cuenta = cliente.getCuentas().get(0); // primera cuenta
        JOptionPane.showMessageDialog(this,
            "Saldo: ₡" + cuenta.getSaldo());
    }

    private void retirarDinero() {
        CuentaBancaria cuenta = cliente.getCuentas().get(0);
        String input = JOptionPane.showInputDialog(this,
            "Por favor, digite el monto que desea retirar:");
        
    if (input == null || input.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error, no se ingresó ningun monto.");
        return;
    }
        try {
            double monto = Double.parseDouble(input);
            cuenta.retirar(monto);
            JOptionPane.showMessageDialog(this,
                "Excelente, su retiro se ha realizado de manera exitosa. Su saldo actual es de: ₡" + cuenta.getSaldo());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lo sentimos, debe ingresar un número que sea válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
