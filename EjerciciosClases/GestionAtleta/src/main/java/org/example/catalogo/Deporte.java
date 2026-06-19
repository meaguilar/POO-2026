package org.example.catalogo;

public enum Deporte {

    // El ID debe coincidir con el id que se guardo en la BD, para seguir utilizando el enum
    NATACION(1002),
    VOLLEYBALL(1003),
    FUTBOL(1004),
    TENIS(1005);

    private final int id;

    Deporte(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
