package modelo;

public abstract class Mascota {

    // Atributo protegido: visible en las subclases
    protected String nombre;

    // Constructor: uso de this
    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    // Método concreto
    public void mostrarNombre() {
        System.out.println("Mi nombre es: " + nombre);
    }

    // Método abstracto: obliga a las hijas a implementarlo
    public abstract void hacerSonido();
}