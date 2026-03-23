import modelo.Gato;
import modelo.InfoMascota;
import modelo.Mascota;
import modelo.Perro;

public class Main {
    public static void main(String[] args) {

        // Creamos objetos concretos
        Perro perro = new Perro("Firulais", "Labrador");
        Gato gato = new Gato("Michi", "Blanco");

        // Uso de métodos concretos (heredados)
        perro.mostrarNombre();
        perro.mostrarInfo();
        perro.hacerSonido();
        perro.hacerSonido("Guau guau muy fuerte!"); // sobrecarga

        System.out.println("------------------------");

        gato.mostrarNombre();
        gato.mostrarInfo();
        gato.hacerSonido();

        System.out.println("------------------------");
        System.out.println("Polimorfismo con arreglo de Mascota:");

        // Polimorfismo en tiempo de ejecución
        Mascota[] mascotas = { perro, gato };

        for (Mascota m : mascotas) {
            m.mostrarNombre();   // mismo método, comportamiento distinto
            m.hacerSonido();     // se llama la versión de la clase concreta
        }

        System.out.println("-----------------------");
        System.out.println("Polimorfismo usando la interfaz Mostrable:");

        InfoMascota[] mostrables = { perro, gato };

        for (InfoMascota most : mostrables) {
            most.mostrarInfo();  // cada clase implementa a su manera
        }
    }
}
