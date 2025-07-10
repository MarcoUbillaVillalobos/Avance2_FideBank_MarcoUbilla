package fidebank;

import java.util.ArrayList;

public class SistemaBanco {
    private ArrayList<Cliente> clientes;

    public SistemaBanco() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente autenticar(String cedula, String pin) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula) && c.validarPin(pin)) {
                return c;
            }
        }
        return null;
    }
}

