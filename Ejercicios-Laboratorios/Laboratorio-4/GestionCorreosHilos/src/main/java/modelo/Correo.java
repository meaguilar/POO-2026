package modelo;

import hilos.Estado;

public class Correo extends Mensaje {

    private Estado estado;

    public Correo() {}
    public Correo(String remitente, String destinario, String asunto) {
        super(remitente, destinario, asunto);
        this.estado = estado.PENDIENTE;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // metodos
    public boolean enviarCorreo(Correo correo) {
        if (correo != null) {
            return true;
        }
        return false;
    }

    public void recibirCorreo() {
        // CAMBIAR EL ESTADO
        this.estado = estado.RECIBIDO;
        System.out.println("Estado: " + this.getEstado());
    }


}
