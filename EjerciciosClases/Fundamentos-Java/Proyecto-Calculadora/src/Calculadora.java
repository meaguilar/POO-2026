import java.util.Scanner;


public class Calculadora {

    // Funciones estáticas para cada operación
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: División entre cero.");
            return 0;
        }
    }

    public static void main(String[] args) {

       Scanner entradaDatos = new Scanner(System.in);
        int opcion;
        double num1 = 0;
        double num2 = 0;
        double resultado = 0;

        do {
            // Menú de la calculadora
            System.out.println("=== Calculadora Básica ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entradaDatos.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número: ");
                num1 = entradaDatos.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                num2 = entradaDatos.nextDouble();

            /*
               switch (opcion) {
                    case 1:
                        resultado = sumar(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 2:
                        resultado = restar(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 3:
                        resultado = multiplicar(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 4:
                        resultado = dividir(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                }
            */

                // switch corto -> una sola instrucción
                switch (opcion) {
                    case 1 -> System.out.println("Resultado: " + sumar(num1, num2));
                    case 2 -> System.out.println("Resultado: " + restar(num1, num2));
                    case 3 -> System.out.println("Resultado: " + multiplicar(num1, num2));
                    case 4 -> System.out.println("Resultado: " + dividir(num1, num2));
                    case 5 -> System.out.println("Salir de la calculadora");
                    default -> System.out.println("Error: Opcion no valida.");
                }

            } else if (opcion != 5) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 5);

        System.out.println("¡Gracias por usar la calculadora!");
        entradaDatos.close();
    }
}