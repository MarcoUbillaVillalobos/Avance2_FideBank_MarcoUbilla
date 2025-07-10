package fidebank;

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Fondos insuficientes.");
        }
        saldo -= monto;
    }
}
