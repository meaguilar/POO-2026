package modelo;

public abstract class Mensaje {
    private String remitente;
    private String destinatario;
    private String asunto;

    public Mensaje() {}
    public Mensaje(String remitente, String destinatario, String asunto) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.asunto = asunto;
    }

    public String getRemitente() {
        return remitente;
    }
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void mostrarMensaje(){
        System.out.println("Remitente: " + remitente);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Asunto: " + asunto);
    }
}
