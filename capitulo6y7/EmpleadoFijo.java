   public class EmpleadoFijo extends Empleado {

    private double salarioMensual;

    public EmpleadoFijo(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return salarioMensual;
    }
}


