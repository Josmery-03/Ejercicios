import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2. Polimorfismo con Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4. Arrays y Referencias");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    ejecutarCuentaBancaria();
                    break;

                case 2:
                    ejecutarEmpleados();
                    break;

                case 3:
                    ejecutarOcultamiento();
                    break;

                case 4:
                    ejecutarArrays();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }


    // EJERCICIO 1

    public static void ejecutarCuentaBancaria() {

        CuentaBancaria cuenta =
                new CuentaBancaria("358-JOS", 1000);

        cuenta.depositar(600);
        cuenta.retirar(200);

        System.out.println("Saldo final: " + cuenta.getSaldo());
    }


    // EJERCICIO 2

    public static void ejecutarEmpleados() {

        Empleado emp1 = new EmpleadoFijo(30000);
        Empleado emp2 = new EmpleadoPorHora(80, 200);

        System.out.println(
                "Salario Empleado Fijo: " +
                emp1.calcularSalario()
        );

        System.out.println(
                "Salario Empleado por Hora: " +
                emp2.calcularSalario()
        );
    }

 
    // EJERCICIO 3

    public static void ejecutarOcultamiento() {

        A obj = new B();

        System.out.println("Valor de x: " + obj.x);


    }

  
    // EJERCICIO 4

    public static void ejecutarArrays() {

        int[] arreglo1 = {10, 20, 30};

        int[] arreglo2 = arreglo1;

        arreglo2[1] = 999;

        System.out.println("Contenido de arreglo1:");

        for (int n : arreglo1) {
            System.out.println(n);
        }
    }
}

