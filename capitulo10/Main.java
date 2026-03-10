package capitulo10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    int fila = 1;

    @Override
    public void start(Stage stage) {

        TextField txtNombre = new TextField();
        TextField txtPoder = new TextField();
        TextField txtPlaneta = new TextField();
        TextField txtTecnica = new TextField();
        TextField txtEdad = new TextField();

        ComboBox<String> comboRaza = new ComboBox<>();
        comboRaza.getItems().addAll(
                "Saiyajin",
                "Humano",
                "Namekiano",
                "Androide",
                "Majin",
                "Freezer Race"
        );

        Button btnAgregar = new Button("Agregar");

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        formulario.add(new Label("Nombre"), 0, 0);
        formulario.add(txtNombre, 1, 0);

        formulario.add(new Label("Raza"), 0, 1);
        formulario.add(comboRaza, 1, 1);

        formulario.add(new Label("Nivel de Poder"), 0, 2);
        formulario.add(txtPoder, 1, 2);

        formulario.add(new Label("Planeta de Origen"), 0, 3);
        formulario.add(txtPlaneta, 1, 3);

        formulario.add(new Label("Técnica Especial"), 0, 4);
        formulario.add(txtTecnica, 1, 4);

        formulario.add(new Label("Edad"), 0, 5);
        formulario.add(txtEdad, 1, 5);

        formulario.add(btnAgregar, 1, 6);

        GridPane gridPersonajes = new GridPane();
        gridPersonajes.setHgap(25);
        gridPersonajes.setVgap(10);
        gridPersonajes.setGridLinesVisible(true);

        Label h1 = new Label("Nombre");
        Label h2 = new Label("Raza");
        Label h3 = new Label("Poder");
        Label h4 = new Label("Planeta");
        Label h5 = new Label("Técnica");
        Label h6 = new Label("Edad");

        h1.getStyleClass().add("header");
        h2.getStyleClass().add("header");
        h3.getStyleClass().add("header");
        h4.getStyleClass().add("header");
        h5.getStyleClass().add("header");
        h6.getStyleClass().add("header");

        gridPersonajes.add(h1, 0, 0);
        gridPersonajes.add(h2, 1, 0);
        gridPersonajes.add(h3, 2, 0);
        gridPersonajes.add(h4, 3, 0);
        gridPersonajes.add(h5, 4, 0);
        gridPersonajes.add(h6, 5, 0);

        btnAgregar.setOnAction(e -> {

            try {

                String nombre = txtNombre.getText();
                String raza = comboRaza.getValue();
                String planeta = txtPlaneta.getText();
                String tecnica = txtTecnica.getText();

                int poder = Integer.parseInt(txtPoder.getText());
                int edad = Integer.parseInt(txtEdad.getText());

                if (nombre.isEmpty() || planeta.isEmpty() || tecnica.isEmpty() || raza == null) {
                    mostrarError("Ningún campo puede quedar vacío");
                    return;
                }

                if (edad <= 0) {
                    mostrarError("La edad debe ser mayor que 0");
                    return;
                }

                if (poder <= 0) {
                    mostrarError("El nivel de poder debe ser mayor que 0");
                    return;
                }

                Personaje p = new Personaje(nombre, raza, poder, planeta, tecnica, edad);

                gridPersonajes.add(new Label(p.getNombre()), 0, fila);
                gridPersonajes.add(new Label(p.getRaza()), 1, fila);
                gridPersonajes.add(new Label(String.valueOf(p.getNivelPoder())), 2, fila);
                gridPersonajes.add(new Label(p.getPlanetaOrigen()), 3, fila);
                gridPersonajes.add(new Label(p.getTecnicaEspecial()), 4, fila);
                gridPersonajes.add(new Label(String.valueOf(p.getEdad())), 5, fila);

                fila++;

                txtNombre.clear();
                txtPoder.clear();
                txtPlaneta.clear();
                txtTecnica.clear();
                txtEdad.clear();
                comboRaza.setValue(null);

            } catch (NumberFormatException ex) {
                mostrarError("Poder y edad deben ser números");
            }

        });

        Label titulo = new Label("PERSONAJES REGISTRADOS");
        titulo.getStyleClass().add("titulo");

        VBox root = new VBox(20, formulario, titulo, gridPersonajes);
        root.setPadding(new Insets(20));

   Scene scene = new Scene(root, 700, 500);

   scene.getStylesheets().add("capitulo10/estilos.css");

   stage.setTitle("Registro Dragon Ball Z");
   stage.setScene(scene);
   stage.show();

    }

    private void mostrarError(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();

    }

    public static void main(String[] args) {
        launch();
    }
}