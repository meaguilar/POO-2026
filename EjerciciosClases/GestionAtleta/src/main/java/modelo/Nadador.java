package modelo;

public class Nadador extends Atleta {

    private String estilo;

    public Nadador() {}
    public Nadador(String nombre, int edad, Deporte deporte,
                   double peso, double altura, double [] horasEntreno,
                   double imc, double promEntreno, String estilo) {
        // atributos heredados
        super(nombre, edad, deporte, peso, altura, horasEntreno, imc, promEntreno);
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void cambiarEstilo(String nuevoEstilo){
        this.estilo = nuevoEstilo;
        System.out.println("Estilo nuevo: " + getEstilo());
    }

    @Override
    public void entrenar(){
        System.out.println("El entrenamiento es en la piscina olimpica de la UES");
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Estilo de nado: " + getEstilo());
    }
}
