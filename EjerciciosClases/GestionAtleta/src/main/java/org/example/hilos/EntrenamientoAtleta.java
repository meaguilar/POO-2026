package org.example.hilos;

import org.example.modelo.Atleta;

public class EntrenamientoAtleta implements Runnable {

    // Crear el atributo que referencia a la clase atleta
    Atleta atleta;

    // Constructor
    public EntrenamientoAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public void run() {

        // Texto que imprima quien esta desarrollando el entrenamiento
        System.out.println("\nAtleta en entrenamiento: " + atleta.getNombre());

        // Ejecuta la lógica del atleta del metodo entrenar (usa el plan internamente)
        atleta.entrenar();

        // Sumar  la duración total del plan de entrenamiento
        double duracionMinutos = 0;


        try {
            for (var ejerciciosDuracion : atleta.getPlanActual().getEjercicios().entrySet()) {
                System.out.println("Ejecutando .... " + ejerciciosDuracion.getKey() + " min. " + ejerciciosDuracion.getValue());
                // Simulación del  tiempo total del entrenamiento
                Thread.sleep((long) (ejerciciosDuracion.getValue() * 60 * 1000));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Entrenamiento interrumpido");
        }

        // Imprimir el entrenamiento ha finalizado por el atleta
        System.out.println("Entrenamiento finalizado  ");
    }
}
