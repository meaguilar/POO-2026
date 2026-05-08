package hilos;

import modelo.Correo;

public class RecepcionCorreo implements Runnable {

    private Correo correo;

    public RecepcionCorreo(Correo correo) {
        this.correo = correo;
    }

    @Override
    public void run() {
        try {

            // Espera de 10 segundos
            Thread.sleep(10000);
            System.out.println("\n Bandeja de entrada (correos recibidos) .... ");
            correo.recibirCorreo();
            correo.mostrarMensaje();

        } catch (InterruptedException e) {
            // Detalles técnicos del error
            e.printStackTrace();
            // mensaje personalizado
            System.out.println("La recepción fue interrumpida");
        }

    }

}
