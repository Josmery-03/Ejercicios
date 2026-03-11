import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InventarioApp extends Application {

    ObservableList<Producto> productos = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        // Campos
        TextField txtNombre = new TextField();
        TextField txtPrecio = new TextField();
        TextField txtCantidad = new TextField();

        Button btnAgregar = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar fila");

        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill:red");

        // Tabla
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto,String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Producto,Double> colPrecio = new TableColumn<>("Precio");
        TableColumn<Producto,Integer> colCantidad = new TableColumn<>("Cantidad");

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        // Formato del precio
        colPrecio.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Double valor, boolean empty) {
                super.updateItem(valor, empty);
                setText(empty || valor == null ? null : String.format("%.2f", valor));
            }
        });

        tabla.getColumns().addAll(colNombre, colPrecio, colCantidad);
        tabla.setItems(productos);

        // Datos del ejemplo
        productos.add(new Producto("Laptop",850.00,5));
        productos.add(new Producto("Mouse",12.50,30));
        productos.add(new Producto("Teclado",35.00,15));

        // Boton agregar
        btnAgregar.setOnAction(e -> {

            String nombre = txtNombre.getText().trim();

            try {

                double precio = Double.parseDouble(txtPrecio.getText().trim());
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());

                Producto nuevo = new Producto(nombre,precio,cantidad);
                productos.add(nuevo);

                txtNombre.clear();
                txtPrecio.clear();
                txtCantidad.clear();
                lblError.setText("");

            } catch(NumberFormatException ex){
                lblError.setText("Precio y Cantidad deben ser números");
            }

        });

        // Botón eliminar
        btnEliminar.setOnAction(e -> {

            Producto seleccionado = tabla.getSelectionModel().getSelectedItem();

            if(seleccionado != null){
                productos.remove(seleccionado);
            }

        });

        // Layout de formulario
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Nombre:"),0,0);
        form.add(txtNombre,1,0);

        form.add(new Label("Precio:"),0,1);
        form.add(txtPrecio,1,1);

        form.add(new Label("Cantidad:"),0,2);
        form.add(txtCantidad,1,2);

        form.add(btnAgregar,2,2);

        VBox root = new VBox(15, form, tabla, btnEliminar, lblError);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root,500,400);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Inventario");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
