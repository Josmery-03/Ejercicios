import javafx.beans.property.*;

public class Producto {
    private SimpleStringProperty nombre;
    private SimpleDoubleProperty precio;
    private SimpleIntegerProperty cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre   = new SimpleStringProperty(nombre);
        this.precio   = new SimpleDoubleProperty(precio);
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    // Getters de Property — requeridos por TableView
    public StringProperty  nombreProperty()   { return nombre; }
    public DoubleProperty  precioProperty()   { return precio; }
    public IntegerProperty cantidadProperty() { return cantidad; }

    // Getters estándar
    public String getNombre()   { return nombre.get(); }
    public double getPrecio()   { return precio.get(); }
    public int    getCantidad() { return cantidad.get(); }
}
