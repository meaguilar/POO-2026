package model;

public enum TipoGaleria {
    FOTOGRAFIA("Fotografía"),
    PINTURA("Pintura"),
    ESCULTURA("Escultura"),
    ILUSTRACION("Ilustración"),
    ARTE_DIGITAL("Arte Digital");

    private final String displayName;
    TipoGaleria(String d) { this.displayName = d; }
    public String getDisplayName() { return displayName; }

    @Override
    public String toString() { return displayName; }
}