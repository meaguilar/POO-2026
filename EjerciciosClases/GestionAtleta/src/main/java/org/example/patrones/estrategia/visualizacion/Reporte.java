package org.example.patrones.estrategia.visualizacion;

import java.time.LocalDate;

public class Reporte {

    private String asunto;
    private LocalDate fecha;
    private EstrategiaVisualizacion estrategia;
    // crear nuevo atributo con tipo de dato StringBuilder
    private StringBuilder firma;


    public Reporte() {
        firma = new StringBuilder();
    }

    // modificacion en el constructor
    public Reporte(String asunto, LocalDate fecha, EstrategiaVisualizacion estrategia, StringBuilder firma) {
        this.asunto = asunto;
        this.fecha = fecha;
        this.estrategia = estrategia;
        this.firma = firma;
    }

    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setEstrategia(EstrategiaVisualizacion estrategia) {
        this.estrategia = estrategia;
    }

    public StringBuilder getFirma() {
        return firma;
    }
    public void setFirma(StringBuilder firma) {
        this.firma = firma;
    }

    // metodos
    public void visualizar(){
        if (estrategia == null) {
            System.out.println("No se encontro estrategia");
        }
        estrategia.visualizar(this);
    }

    // implementación de sincronización
    public synchronized void firmarReporte(String firma) {
        this.firma.append(firma);
    }

}
