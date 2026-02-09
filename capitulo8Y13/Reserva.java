import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

    private String nombreCliente;
    private Date fechaReserva;
    private int cantidadPersonas;

    // Constructor con validaciones
    public Reserva(String nombreCliente, Date fechaReserva, int cantidadPersonas)
            throws ReservaInvalidaException {

        // Validar nombre
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new ReservaInvalidaException(
                    "El nombre del cliente es inválido.");
        }

        // Normalizar nombre
        nombreCliente = nombreCliente.trim();

        // Validar fecha
        if (fechaReserva == null) {
            throw new ReservaInvalidaException(
                    "La fecha de la reserva es inválida.");
        }

        // Validar cantidad
        if (cantidadPersonas <= 0) {
            throw new ReservaInvalidaException(
                    "La cantidad de personas debe ser mayor que cero.");
        }

        // Asignar valores
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.cantidadPersonas = cantidadPersonas;
    }

    // Getters 
    public String getNombreCliente() {
        return nombreCliente;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    // Metodo para mostrar la reserva
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Cliente: " + nombreCliente +
               " | Fecha: " + sdf.format(fechaReserva) +
               " | Personas: " + cantidadPersonas;
    }
}


