package contador;

public class HiloContador extends Thread {

    Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {

            System.out.println("\n" + Thread.currentThread().getName() + " entrando al recurso compartido");

            // Incrementa cada 3 segundos
            //Thread.sleep(3000);
            for (int i = 0; i < 100; i++) {
                contador.incrementar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
