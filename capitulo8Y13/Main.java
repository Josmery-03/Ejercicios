import java.text.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Reserva> listaReservas = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== MENU RESERVAS =====");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Mostrar reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    registrarReserva();
                    break;

                case 2:
                    mostrarReservas();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);
    }

    
    // Registrar reserva
    public static void registrarReserva() {

        try {

            System.out.print("Nombre del cliente: ");
            String nombre = sc.nextLine();

            // Comparacion de cadenas usando equalsIgnoreCase
            for (Reserva r : listaReservas) {
                if (r.getNombreCliente().equalsIgnoreCase(nombre.trim())) {
                    System.out.println(
                        "Advertencia: Ya existe una reserva a ese nombre.");
                }
            }

            System.out.print("Fecha (dd/MM/yyyy): ");
            String fechaTexto = sc.nextLine();

            // Validar y convertir fecha
            SimpleDateFormat sdf =
                    new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);

            Date fecha = sdf.parse(fechaTexto);

            System.out.print("Cantidad de personas: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            // Crear reserva 
            Reserva reserva =
                    new Reserva(nombre, fecha, cantidad);

            listaReservas.add(reserva);

            System.out.println("Reserva registrada correctamente.");

        } catch (ParseException e) {

            System.out.println(
                "Error: Formato de fecha invalido. Use dd/MM/yyyy.");

        } catch (ReservaInvalidaException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error inesperado: " + e.getMessage());
            sc.nextLine();
        }
    }

    // Mostrar reservas
    public static void mostrarReservas() {

        if (listaReservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE RESERVAS =====");

        for (Reserva r : listaReservas) {
            System.out.println(r);
        }
    }
}

