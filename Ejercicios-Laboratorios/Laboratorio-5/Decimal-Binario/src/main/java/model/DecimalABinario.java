package model;

import patterns.strategy.EstrategiaConversion;

public class DecimalABinario implements EstrategiaConversion {
    @Override
    public String convertir(String valor) {
        int numero = Integer.parseInt(valor.trim());

        if (numero < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo.");
        }
        if (numero == 0) {
            return "0";
        }

        StringBuilder binario = new StringBuilder();
        int temp = numero;
        while (temp > 0) {
            binario.insert(0, temp % 2);
            temp = temp / 2;
        }
        return binario.toString();
    }
}
