package capitulo12y14.capitulo14;

import java.io.*;
import java.util.ArrayList;

public class BusquedaRAF {

    private static final String INDICE = "indice.idx";

    // Guardar matricula en indice
    public static void agregarIndice(String matricula, int posicion) {

        try (RandomAccessFile raf =
                new RandomAccessFile(INDICE, "rw")) {

            raf.seek(raf.length()); 
            raf.writeUTF(matricula);
            raf.writeInt(posicion);

        } catch (IOException e) {
            System.out.println("Error guardando índice.");
        }
    }

    // Buscar matricula usando indice
    public static void buscar(String matricula,
                              ArrayList<Estudiante> lista) {

        try (RandomAccessFile raf =
                new RandomAccessFile(INDICE, "r")) {

            while (raf.getFilePointer() < raf.length()) {

                String mat = raf.readUTF();
                int pos = raf.readInt();

                if (mat.equals(matricula)) {
                    System.out.println("Estudiante encontrado:");
                    System.out.println(lista.get(pos));
                    return;
                }
            }

            System.out.println("No se encontro la matricula.");

        } catch (FileNotFoundException e) {
            System.out.println("No existe archivo indice.");
        } catch (IOException e) {
            System.out.println("Error en la busqueda.");
        }
    }
}
