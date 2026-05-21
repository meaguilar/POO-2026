package contador;

public class TareaContador implements Runnable {

    Contador contador;

    public TareaContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {

        System.out.println("\n" + Thread.currentThread().getName() + " entrando al recurso compartido");

        for (int i = 0; i < 10; i++) {
            contador.decrementar();
        }
    }
}
