package hilos;

import modelo.Correo;

public class EnvioCorreo implements Runnable {

    Correo correo;

    public EnvioCorreo(Correo correo) {
        this.correo = correo;
    }

    @Override
    public void run() {
        try {

            System.out.println("\nEnviando correo...");

            // Espera de 5 segundos
            Thread.sleep(5000);

            boolean enviado = correo.enviarCorreo(correo);

            if (enviado) {
                System.out.println("\nDetalles del correo enviado: ");
                correo.mostrarMensaje();
            } else {
                System.out.println("Error al enviar el correo");
            }

        } catch (InterruptedException e) {
            // Detalles técnicos del error
            e.printStackTrace();
            // mensaje personalizado
            System.out.println("El envío fue interrumpido");
        }
    }
}
