package org.example.hilos;

import org.example.modelo.Atleta;
import org.example.modelo.Entrenador;
import org.example.modelo.GestorReporte;
import org.example.patrones.estrategia.visualizacion.Reporte;

public class EvaluacionEntrenamiento implements Runnable {

    // Crear el atributo que referencia a la clase atleta y el entrenador
    private Atleta atleta;
    private Entrenador entrenador;

    // crear referencias a la clase Gestor reporte y Reporte
    GestorReporte gestorReporte;
    Reporte reporte;

    // Constructor modificar
    public EvaluacionEntrenamiento(Atleta atleta, Entrenador entrenador, GestorReporte gestorReporte, Reporte reporte) {
        this.atleta = atleta;
        this.entrenador = entrenador;
        this.gestorReporte = gestorReporte;
        this.reporte = reporte;
    }

    @Override
    public void run() {

        Atleta atletaEncontrado = entrenador.obtenerAtletaPorNombre(atleta);

        if (atletaEncontrado != null) {

            String atletaAsignado = atletaEncontrado.getNombre();

            // Imprimir nombre del entrenador y el atleta que esta evaluando
            System.out.println("\nEntrenador responsable: " + entrenador.getNombre());
            System.out.println("Atleta entrenando: " + atletaAsignado);

            // Simula evaluación cada 5 segundos sumados al valor en minutos de cada ejercicios
            try {
                for (var ejerciciosDuracion : atleta.getPlanActual().getEjerciciosDuracion().entrySet()) {
                    System.out.println("Evaluando .... " + ejerciciosDuracion.getKey());
                    // Simulación de la evaluacion 5 segundos mas el tiempo de cada ejercicio
                    Thread.sleep((long) ((ejerciciosDuracion.getValue() * 60 * 1000) + 5000));
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Evaluación interrumpida");
            }

            // Texto que indica que el entrenador esta generando la retroalimentacion
            System.out.println("Generando retroalimentación .......");
            // invocar metodos  firmar y guardar
            reporte.firmarReporte(" atleta: [" + atletaAsignado + "]  - entrenador: [" + entrenador.getNombre() + "]\n");
            gestorReporte.guardarReportes(reporte);
        }else {
            System.out.println("Atleta no encontrado en la lista del entrenador: " + entrenador.getNombre());
        }
    }
}
