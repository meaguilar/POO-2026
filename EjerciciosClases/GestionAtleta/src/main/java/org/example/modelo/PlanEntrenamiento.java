package org.example.modelo;

import java.util.HashMap;
import java.util.Map;

public class PlanEntrenamiento implements Imprimible {

    // atributos
    private Map<String, Double> ejercicios;
    private String objetivo;

    // constructores
    public PlanEntrenamiento() {
        ejercicios = new HashMap<>();
    }
    public PlanEntrenamiento(String objetivo) {
        this.objetivo = objetivo;
        ejercicios = new HashMap<String, Double>();
    }

    // setter/getter
    public Map<String, Double> getEjercicios() {
        return ejercicios;
    }
    public void setEjercicios(Map<String, Double> ejercicios) {
        this.ejercicios = ejercicios;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    // metodos
    @Override
    public void imprimir() {
        System.out.println("- Objetivo: " + objetivo);
        for (Map.Entry<String, Double> ejercicio : ejercicios.entrySet()) {
            System.out.println("- Ejercicio: " + ejercicio.getKey());
            System.out.println("- Duración en minutos: " + ejercicio.getValue());
        }
    }

    public boolean agregarEjercicio(String ejercicio, double duracion) {
        // Retorna true si el ejercicio NO existía previamente
        return ejercicios.put(ejercicio, duracion) == null;
    }
}
