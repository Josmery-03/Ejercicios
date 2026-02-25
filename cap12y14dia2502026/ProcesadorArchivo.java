package cap12y14dia2502026;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesadorArchivo extends Thread {

    private String nombreArchivo;
    private ResultadoCompartido resultado;

    public ProcesadorArchivo(String nombreArchivo, ResultadoCompartido resultado) {
        this.nombreArchivo = nombreArchivo;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.trim().split("\\s+");
                contador += palabras.length;
            }

            resultado.agregarResultado(nombreArchivo, contador);

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + nombreArchivo);
        }
    }
}