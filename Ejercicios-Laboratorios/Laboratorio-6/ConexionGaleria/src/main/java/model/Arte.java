package model;

/**
 * POJO que representa una fila de la tabla "arte":
 * id_arte SERIAL, nombre_arte VARCHAR(100), url_arte VARCHAR(255).
 * La url apunta a una imagen que JavaFX descarga en tiempo de ejecucion.
 */
public class Arte {
    private int idArte;
    private String nombreArte;
    private String urlArte;

    public Arte() {
    }

    public Arte(int idArte, String nombreArte, String urlArte) {
        this.idArte = idArte;
        this.nombreArte = nombreArte;
        this.urlArte = urlArte;
    }

    public int getIdArte() {
        return idArte;
    }

    public void setIdArte(int idArte) {
        this.idArte = idArte;
    }

    public String getNombreArte() {
        return nombreArte;
    }

    public void setNombreArte(String n) {
        this.nombreArte = n;
    }

    public String getUrlArte() {
        return urlArte;
    }

    public void setUrlArte(String u) {
        this.urlArte = u;
    }

    public String mostrarInformacion() {
        return "Arte{id=" + idArte + ", nombre='" + nombreArte + "', url='" + urlArte + "'}";
    }

    @Override
    public String toString() {
        return nombreArte;
    }
}
