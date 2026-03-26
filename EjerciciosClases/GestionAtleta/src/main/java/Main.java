import modelo.Deporte;
import modelo.Nadador;

public class Main {
    public static void main(String[] args) {

        Nadador nadador1 = new Nadador("Florencia", 20, Deporte.NATACION,
                55, 1.70, new double[]{2, 4, 6, 7, 3, 5, 2},
                0.0, 0.0, "Mariposa");

        nadador1.imprimir();
        nadador1.setImc(nadador1.calcularIMC());
        nadador1.setPromHorasEntrenamiento(nadador1.calcularPromedioSemanalEntrenamiento());
        nadador1.cambiarEstilo("Libre (Crol)");
        System.out.print("Clasificación del IMC: ");
        nadador1.clasificarIMC();
        System.out.print("Clasificación del rendimiento: ");
        nadador1.clasificarRendimiento();
        nadador1.entrenar();
    }
}
