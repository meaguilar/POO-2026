package modelo;

/**
 * Clase Gato que HEREDA de Mascota e IMPLEMENTA Mostrable
 * Muestra que MÚLTIPLES clases pueden heredar de la misma abstracta
 */
public class Gato extends Mascota implements InfoMascota {

    private String color;

    public Gato(String nombre, String color) {
        super(nombre);         // uso de super: llama al constructor de Mascota
        this.color = color;    // uso de this: atributo de esta clase
    }
    /**
     *  POLIMORFISMO: Cada clase tiene su SONIDO diferente
     *    Aunque se llama igual que en Perro
     */
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    /**
     *  INTERFAZ: Cada clase implementa mostrarInfo() A SU MANERA
     *    Aunque todas deben tener este método
     */
    @Override
    public void mostrarInfo() {
        System.out.println("Soy un gato llamado " + nombre + " de color " + color);
    }
}
