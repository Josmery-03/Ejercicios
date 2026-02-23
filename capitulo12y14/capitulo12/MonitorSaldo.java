package capitulo12y14.capitulo12;

public class MonitorSaldo extends Thread {

    private Boveda boveda;

    public MonitorSaldo(Boveda boveda) {
        this.boveda = boveda;

        // Convertir a demonio
        setDaemon(true); 
    }

    @Override 
    public void run() {

        try {
            while (true) {
                System.out.println(">>> MONITOR: Saldo actual en boveda = $" + boveda.getSaldo());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
