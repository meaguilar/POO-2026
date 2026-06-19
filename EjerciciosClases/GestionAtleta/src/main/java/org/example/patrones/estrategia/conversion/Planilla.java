package org.example.patrones.estrategia.conversion;

import org.example.modelo.Pagable;

public class Planilla {
    private Pagable pago;
    private EstrategiaConversionMoneda estrategia;

    // Constructor
    public Planilla() {}
    public Planilla(Pagable pago, EstrategiaConversionMoneda estrategia) {
        this.pago = pago;
        this.estrategia = estrategia;
    }

    // Setter / Getter
    public Pagable getPago() {
        return pago;
    }
    public void setPago(Pagable pago) {
        this.pago = pago;
    }
    public EstrategiaConversionMoneda getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(EstrategiaConversionMoneda estrategia) {
        this.estrategia = estrategia;
    }

    // metodos
    public double obtenerSalarioCalculado(){
        return pago.calcularSalario();
    }

    public double convertirSalario(){
        return estrategia.convertirMoneda(pago.calcularSalario());
    }

}
