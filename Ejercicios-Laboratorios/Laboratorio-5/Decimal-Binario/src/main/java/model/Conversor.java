package model;

import patterns.strategy.EstrategiaConversion;

public class Conversor {
    private String valor;
    private EstrategiaConversion estrategia;

    public Conversor() {
    }

    public Conversor(String valor, EstrategiaConversion estrategia) {
        this.valor = valor;
        this.estrategia = estrategia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public EstrategiaConversion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaConversion estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Delega la conversión a la estrategia actualmente asignada.
     *
     * @return String con el resultado de la conversión.
     */
    public String ejecutarConversion() {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingresa una cantidad.");
        }

        if (estrategia == null) {
            throw new IllegalStateException("No se ha definido la estrategia.");
        }

        return estrategia.convertir(valor);
    }
}
