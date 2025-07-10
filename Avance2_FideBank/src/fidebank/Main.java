package fidebank;
/**
 * Universidad Fidélitas / II Cuatrimestre 2025 / Programación Cliente - Servidor Concurrente
 * Elaborado por: Marco Antonio Ubilla Villalobos
 * Nombre del docente: Vargas Montes Mario Alberto
 * Fecha de entrega: Martes, 15 de julio de 2025
 */
public class Main {
    public static void main(String[] args) {
        SistemaBanco sistema = new SistemaBanco();
        
        Cliente cliente = new Cliente("Marco Ubilla Villalobos", "198020205", "Fidelitas");
        CuentaBancaria cuenta = new CuentaBancaria("CUENTA-01", 75000.0);
        cliente.agregarCuenta(cuenta);
        sistema.agregarCliente(cliente);
        
        new VentanaLogin(sistema);
    }
}

