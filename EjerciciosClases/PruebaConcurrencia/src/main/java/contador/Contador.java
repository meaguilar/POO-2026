package contador;

public class Contador {

    private int valor;

    // Crear un candado independiente para controlar la sincronización
    private final Object lock = new Object();

    public Contador(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }


    // Comenta y descomenta para que visualices la diferencia

    // Metodos sin sincronización
    /*public void incrementar() {
        valor++;
    }*/
    /*public void decrementar() {
        valor--;
    }*/

    // Metodos con sincronizacion

    // Un hilo a la vez puede ejecutar este metodo
    public synchronized void incrementar() {
        // Retardando el proceso para poder visualizar el estado BLOCKED
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.valor++;
    }

    public synchronized void decrementar() {
        // Retardando el proceso para poder visualizar el estado BLOCKED
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (valor < 100) {
            this.valor--;
        }
    }

    // Un hilo a la vez puede ejecutar este metodo .. solo una parte del código se bloquea
   /* public void incrementar() {
        synchronized (lock) {
            this.valor++;
        }
    }*/

   /* public void decrementar() {
        synchronized (lock) {
            this.valor--;
        }
    }*/

}