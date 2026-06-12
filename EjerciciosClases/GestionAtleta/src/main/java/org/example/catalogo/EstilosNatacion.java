package org.example.catalogo;

public enum EstilosNatacion {
    LIBRE("Libre"),
    ESPALDA("Espalda"),
    PECHO("Pecho"),
    MARIPOSA("Mariposa");

    private final String nombre;

    EstilosNatacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
