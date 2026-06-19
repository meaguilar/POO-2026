package org.example.patrones.estrategia;

import org.example.util.GeneradorRandom;

public class AdivinaNumero implements EstrategiaJuego {

    private int numeroSecreto;
    private int numeroUsuario;

    public AdivinaNumero() {
        this.numeroSecreto = GeneradorRandom.generarNumero(1,100);
    }

    public AdivinaNumero(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
        this.numeroSecreto = GeneradorRandom.generarNumero(1,100);
    }

    public void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    @Override
    public String jugar() {
        if (numeroUsuario < numeroSecreto) {
            return "Más alto";
        }
        if (numeroUsuario > numeroSecreto) {
            return "Más bajo";
        }
        return "¡Adivinastes!";
    }
}
