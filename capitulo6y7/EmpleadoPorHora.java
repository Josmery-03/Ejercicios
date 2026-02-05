public class EmpleadoPorHora extends Empleado {

    private int horas;
    private double pagoHora;

    public EmpleadoPorHora(int horas, double pagoHora) {
        this.horas = horas;
        this.pagoHora = pagoHora;
    }

    @Override
    public double calcularSalario() {
        return horas * pagoHora;
    }
}
