package capitulo12y14.capitulo12;


import java.util.Random;

public class Cajero extends Thread {

    private Boveda boveda;
    private int transacciones = 0;
    private Random rand = new Random();

    public Cajero(String nombre, Boveda boveda) {
        super(nombre);
        this.boveda = boveda;
    }

    public int getTransacciones() {
        return transacciones;
    }

    @Override
    public void run() {
        // De 3 a 5 clientes 
        int clientes = rand.nextInt(3) + 3; 

        for (int i = 1; i <= clientes; i++) {
            try {

                // De 500 a 2000
                int monto = rand.nextInt(1501) + 500; 

                boveda.retirar(getName(), monto);
                transacciones++;

                // Simula tiempo de transaccion, de 1 a 3 segundos
                Thread.sleep((rand.nextInt(3) + 1) * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getName() + " ha terminado sus operaciones.");
    }
}
