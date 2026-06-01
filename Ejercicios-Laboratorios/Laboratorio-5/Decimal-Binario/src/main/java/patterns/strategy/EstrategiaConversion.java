package patterns.strategy;

public interface EstrategiaConversion {
    /**
     * Ejecuta la conversión sobre el valor recibido.
     *
     * @param valor String con el número a convertir.
     * @return String con el resultado de la conversión.
     */
    String convertir(String valor);
}
