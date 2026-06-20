package model;

/**
 * Catalogo cerrado de tipos de obra. Cada constante tiene un nombre
 * legible (displayName) para mostrar al usuario.
 */
public enum TipoGaleria {
    FOTOGRAFIA("Fotografia"),
    PINTURA("Pintura"),
    ESCULTURA("Escultura"),
    ILUSTRACION("Ilustracion"),
    ARTE_DIGITAL("Arte Digital");

    private final String displayName;

    TipoGaleria(String d) {
        this.displayName = d;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
