public class CuentaBancaria {

    // Atributos privados de "saldo" y "numeroCuenta"
    private double saldo;
    private String numeroCuenta;

    // Constructor que inicializa dichos atributos
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Metodo depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("El deposito ha sido realizado con exitos. Su nuevo saldo es de: " + saldo);
        } else {
            System.out.println("Monto invalido.");
        }
    }
    // Metodo retirar
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Su retiro ha sido realizado con exitos. El nuevo saldo es de: " + saldo);
        } else {
            System.out.println("No hay dinero suficiente.");
        }
    }
    
    // Metodo getSaldo
    public double getSaldo() {
        return saldo;
    }
}
