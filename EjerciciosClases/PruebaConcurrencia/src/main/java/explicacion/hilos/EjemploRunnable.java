package explicacion.hilos;

public class EjemploRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("\nHilo ejecutandose desde la clase implementada con Runnable");
    }
}
