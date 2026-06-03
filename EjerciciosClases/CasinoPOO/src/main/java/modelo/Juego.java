package modelo;

import patrones.estrategia.EstrategiaJuego;

public class Juego {
    private String nombre;
    private String descripcion;
    private EstrategiaJuego estrategia;

    public Juego() {

    }

    public Juego(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstrategiaJuego getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaJuego estrategia) {
        this.estrategia = estrategia;
    }

    public String iniciarJuego() {
        if (estrategia != null) {
            return estrategia.jugar();
        } else {
            return "No hay juego seleccionado";
        }
    }
}
