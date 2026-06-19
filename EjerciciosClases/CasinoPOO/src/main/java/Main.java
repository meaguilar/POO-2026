import org.example.modelo.Juego;
import org.example.patrones.estrategia.AdivinaNumero;
import org.example.patrones.estrategia.SieteSuerte;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== MENÚ DE JUEGOS ===");
        System.out.println("1. Siete de la Suerte");
        System.out.println("2. Adivina el Número");
        System.out.print("Seleccione una opción: ");

        int opcion = sc.nextInt();

        Juego juego = new Juego();

        switch (opcion) {

            case 1:
                SieteSuerte estrategiaSuerte = new SieteSuerte();
                juego.setEstrategia(estrategiaSuerte);
                System.out.println(juego.iniciarJuego());
                break;

            case 2:

                AdivinaNumero estrategia = new AdivinaNumero();
                juego.setEstrategia(estrategia);

                String resultado;
                int intentos = 3;

                do {
                    System.out.print("Ingresa un número: ");
                    int numeroJugador = sc.nextInt();

                    estrategia.setNumeroUsuario(numeroJugador);

                    resultado = juego.iniciarJuego();

                    System.out.println(resultado);

                intentos--;

                } while (intentos > 0 && !resultado.equals("¡Adivinastes!"));

                if (intentos == 0) {
                    resultado = "Te quedastes sin créditos";
                    System.out.println(resultado);
                }
                break;

            default:
                System.out.println("Opción no válida");
        }

    }

}
