package explicacion.hilos;

public class EjemploThread extends Thread {

    // Al ejecutarse el metodo run el estado cambia a RUNNING
    @Override
    public void run() {

        // Manejo de excepciones
        try {
            // Estado cambia - TIME_WAITING
            Thread.sleep(5000);
            System.out.println("\nHilo ejecutandose con la clase Thread");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
