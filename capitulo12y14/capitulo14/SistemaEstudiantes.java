package capitulo12y14.capitulo14;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEstudiantes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> lista =
                ArchivoEstudiantes.cargar();

        int opcion;

        do {
            System.out.println("\n==== SISTEMA DE ESTUDIANTES ====");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar por matricula");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Matricula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Promedio: ");
                    double promedio = sc.nextDouble();

                    Estudiante nuevo =
                            new Estudiante(nombre,
                                           matricula,
                                           promedio);

                    lista.add(nuevo);

                    // Guardar datos
                    ArchivoEstudiantes.guardar(lista);

                    // Guardar indice
                    BusquedaRAF.agregarIndice(
                            matricula,
                            lista.size() - 1
                    );

                    System.out.println("Estudiante agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese matricula: ");
                    String m = sc.nextLine();
                    BusquedaRAF.buscar(m, lista);
                    break;

                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Estudiante e : lista) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}
