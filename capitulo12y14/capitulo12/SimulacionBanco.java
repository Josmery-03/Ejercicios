package capitulo12y14.capitulo12;

public class SimulacionBanco {

    public static void main(String[] args) {

        Boveda boveda = new Boveda();

        Cajero cajero1 = new Cajero("Cajero 1", boveda);
        Cajero cajero2 = new Cajero("Cajero 2", boveda);
        Cajero cajero3 = new Cajero("Cajero 3", boveda);

        // Hilo demonio
        MonitorSaldo monitor = new MonitorSaldo(boveda);
        monitor.start();

        // Iniciar cajeros
        cajero1.start();
        cajero2.start();
        cajero3.start();

        try {
            // Esperar a que terminen
            cajero1.join();
            cajero2.join();
            cajero3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Resumen final
        System.out.println("\n====== RESUMEN FINAL ======");
        System.out.println("Transacciones Cajero 1: " + cajero1.getTransacciones());
        System.out.println("Transacciones Cajero 2: " + cajero2.getTransacciones());
        System.out.println("Transacciones Cajero 3: " + cajero3.getTransacciones());
        System.out.println("Saldo final en la boveda: $" + boveda.getSaldo());
    }
}
