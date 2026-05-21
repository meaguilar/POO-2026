import explicacion.hilos.EjemploRunnable;
import explicacion.hilos.EjemploThread;

public class MainHilos {

    public static void main(String[] args) {

        // Crear el hilo - estado NEW
        EjemploThread h1 = new EjemploThread();

        // Crear la tarea - estado RUNNABLE
        EjemploRunnable tarea = new EjemploRunnable();

        // crear el hilo para asignar la tarea  - estado NEW
        Thread h2 = new Thread(tarea);

        // Imprimiendo el estado del hilo
        System.out.println("\nEstado actual de los hilos - [Hilo1:" + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

        // Iniciar el hilo -> cambia al estado RUNNABLE
        h1.start();
        h2.start();

        // Imprimiendo el estado del hilo
        System.out.println("\nEstado actual de los hilos - [Hilo1:" + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

        // Imprimiendo el estado actual de los hilos durante su ejecución
        System.out.println("\nEstado actual de los hilos - [Hilo1:" + h1.getState() + ", Hilo2: " + h2.getState() + " ]");

        // Manejo de excepciones
        try {
            // Todos los hilos a excepcion del hilo1 se encuentran en estado WAIT
            h1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimiendo el estado del hilo
        System.out.println("\nEstado actual de los hilos - [Hilo1:" + h1.getState() + ", Hilo2: " + h2.getState() + " ]");


        // Al mostrarse el texto en consola  el estado cambia a TERMINATED
        System.out.println("\nHilo principal ejecutandose");

    }
}
