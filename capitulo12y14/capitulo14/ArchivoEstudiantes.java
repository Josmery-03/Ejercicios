package capitulo12y14.capitulo14;

import java.io.*;
import java.util.ArrayList;

public class ArchivoEstudiantes {

    private static final String ARCHIVO = "estudiantes.dat";

    public static ArrayList<Estudiante> cargar() {

        ArrayList<Estudiante> lista = new ArrayList<>();

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            lista = (ArrayList<Estudiante>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe, se creara uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return lista;
    }

    public static void guardar(ArrayList<Estudiante> lista) {

        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            oos.writeObject(lista);

        } catch (IOException e) {
            System.out.println("Error guardando archivo: " + e.getMessage());
        }
    }
}
