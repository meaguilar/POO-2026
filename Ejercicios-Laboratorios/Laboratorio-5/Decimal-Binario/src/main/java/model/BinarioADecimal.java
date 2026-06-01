package model;

import patterns.strategy.EstrategiaConversion;

public class BinarioADecimal implements EstrategiaConversion {
    @Override
    public String convertir(String valor) {
        String binario = valor.trim();

        if (!binario.matches("[01]+")) {
            throw new IllegalArgumentException("Solo se permiten 0s y 1s en el binario.");
        }

        int decimal = 0;
        int longitud = binario.length();
        for (int i = 0; i < longitud; i++) {
            int bit = Character.getNumericValue(binario.charAt(i));
            decimal += bit * (int) Math.pow(2, longitud - 1 - i);
        }
        return String.valueOf(decimal);
    }
}
