import hilos.EnvioCorreo;
import hilos.RecepcionCorreo;
import modelo.Correo;

public class Main {
    public static void main(String[] args) {

        Correo correoEnviar =
                new Correo("uca@uca.edu.sv",
                        "poo@uca.edu.sv",
                        "Primer correo");

        Correo correoRecibir = new Correo(
                 "poo@uca.edu.sv",
                 "secciones_poo@uca.edu.sv",
                "Cuarto laboratorio POO");

        // Creando los objetos (tareas) de la clase que implementa Runnable
        // Simulando un envio y un recepcion de correo
        EnvioCorreo envio = new EnvioCorreo(correoEnviar);
        RecepcionCorreo recepcion = new RecepcionCorreo(correoRecibir);

        // Creando el hilo para agregar los objetos (tareas)
        Thread hiloEnvio = new Thread(envio);
        Thread hiloRecepcion = new Thread(recepcion);

        // Iniciando los hilos
        hiloEnvio.start();
        hiloRecepcion.start();

    }
}
