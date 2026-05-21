
import contador.Contador;
import contador.HiloContador;
import contador.TareaContador;


public class MainContador {

    public static void main(String[] args) {

        Contador contador = new Contador(0);

        HiloContador h0 = new HiloContador(contador);
        HiloContador h1 = new HiloContador(contador);

        TareaContador tarea = new TareaContador(contador);
        Thread h2 = new Thread(tarea);

        // Estado  - NEW
        System.out.println("\nEstado actual de los hilos - [Hilo0:" + h0.getState() + ", Hilo1: " + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

        h0.start();
        h1.start();
        h2.start();

        // Estado  - RUNNABLE
        System.out.println("\nEstado actual de los hilos - [Hilo0:" + h0.getState() + ", Hilo1: " + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

        try {
            // Aumentar el tiempo de visualización de estados
            Thread.sleep(50);
            // Estados  - TIME WAITING, BLOCKED
            System.out.println("\nEstado actual de los hilos - [Hilo0:" + h0.getState() + ", Hilo1: " + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

            h0.join();
            h1.join();
            h2.join();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Estados - TERMINATED
        System.out.println("\nEstado actual de los hilos - [Hilo0:" + h0.getState() + ", Hilo1: " + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

        System.out.println("Hilo principal - Valor final: " + contador.getValor());

    }
}
