package org.example.patrones.estrategia.conversion;

public class ConversionDolarPesosMexicanos implements EstrategiaConversionMoneda{

    // Valor hasta 2026 de un dolar en peso mexicano
    private final double TIPO_CAMBIO = 17.4;

    @Override
    public double convertirMoneda(double monto){
        return monto * TIPO_CAMBIO;
    }
}
