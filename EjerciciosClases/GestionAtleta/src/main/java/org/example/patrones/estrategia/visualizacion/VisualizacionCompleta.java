package org.example.patrones.estrategia.visualizacion;

public class VisualizacionCompleta implements EstrategiaVisualizacion {

    @Override
    public void visualizar(Reporte reporte){
        System.out.println("\nReporte completo");
        System.out.println("Fecha: " + reporte.getFecha());
        System.out.println("Asunto: " + reporte.getAsunto());
        System.out.println("Firma:" + reporte.getFirma().toString());
    }

}
