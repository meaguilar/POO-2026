package org.example.patrones.estrategia.visualizacion;

public class VisualizacionSimple implements EstrategiaVisualizacion{

    public void visualizar(Reporte reporte) {
        System.out.println("\nReporte completo");
        System.out.println("Asunto: " + reporte.getAsunto());
    }
}
