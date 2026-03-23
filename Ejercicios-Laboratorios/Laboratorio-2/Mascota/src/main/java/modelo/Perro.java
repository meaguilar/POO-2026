package modelo;

/**
 * Clase Perro que HEREDA de Mascota (clase abstracta)
 * e IMPLEMENTA la interfaz Mostrable
 */
public class Perro extends Mascota implements InfoMascota {

    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre);           // uso de super: llama al constructor de Mascota
        this.raza = raza;        // uso de this: atributo de esta clase
    }
    /**
     *  POLIMORFISMO EJECUCIÓN: @Override SOBREESCRIBE el método abstracto
     *    Cada clase hija da su PROPIA implementación
     */
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    /**
     *  POLIMORFISMO COMPILACIÓN: SOBRECARGA del mismo método
     *    Mismo nombre, pero DIFERENTES parámetros
     */
    public void hacerSonido(String sonidoPersonalizado) {
        System.out.println(sonidoPersonalizado);
    }

    /**
     *  INTERFAZ: Obligado a implementar mostrarInfo()
     *    @Override indica que cumple con el contrato de Mostrable
     */
    @Override
    public void mostrarInfo() {
        System.out.println("Soy un perro llamado " + nombre + " de raza " + raza);
    }
}