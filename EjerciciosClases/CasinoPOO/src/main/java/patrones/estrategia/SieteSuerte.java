package patrones.estrategia;

import util.GeneradorRandom;

public class SieteSuerte implements EstrategiaJuego {

    private int numeroSecreto;

    public SieteSuerte() {
        this.numeroSecreto = GeneradorRandom.generarNumero(1, 10);
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }

    @Override
    public String jugar() {

        if (numeroSecreto == 7) {
            return "¡Ganastes!";
        } else {
            return "¡Has perdido!";
        }
    }
}
