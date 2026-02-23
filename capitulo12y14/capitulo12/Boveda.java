package capitulo12y14.capitulo12;

public class Boveda {

    private int saldo = 50000;

    // Aplicacion del metodo synchronized
    public synchronized boolean retirar(String cajero, int monto) {

        if (saldo >= monto) {
            System.out.println(cajero + " retirando $" + monto);
            saldo -= monto;
            System.out.println("Saldo restante: $" + saldo);
            return true;
        } else {
            System.out.println(cajero + " intento retirar $" + monto + " pero no hay fondos suficientes");
            return false;
        }
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}