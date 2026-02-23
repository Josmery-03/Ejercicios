package capitulo12y14.capitulo14;

import java.io.Serializable;

public class Estudiante implements Serializable {
 
    // Atributos privados
    private String nombre;
    private String matricula;
    private double promedio;

    // Constructor
    public Estudiante(String nombre, String matricula, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    // Getters 
    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               " Matricula: " + matricula +
               " Promedio: " + promedio;
    }
}