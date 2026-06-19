package org.example.patrones.estrategia.conversion;

public class ConversionDolarEuro implements EstrategiaConversionMoneda{

    // Valor hasta 2026 de un dolar en euro
    private final double TIPO_CAMBIO = 0.95;

    @Override
    public double convertirMoneda(double monto){
        return monto * TIPO_CAMBIO;
    }
}
