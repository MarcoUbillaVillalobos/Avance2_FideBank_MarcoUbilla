package fidebank;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cedula;
    private String pin;
    private ArrayList<CuentaBancaria> cuentas;

    public Cliente(String nombre, String cedula, String pin) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.pin = pin;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public boolean validarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }
    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }
    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }
}