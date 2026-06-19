package org.example.modelo;

import org.example.patrones.estrategia.visualizacion.Reporte;
import org.example.servicios.GestorReporte;

import java.util.ArrayList;
import java.util.List;

public class Entrenador implements Pagable, Imprimible {
    private int id;
    String nombre;
    // años de experiencia
    int experiencia;
    double salario;
    // Colección lista
    List <Atleta> atletasAsignados;

    private static int contadorId = 0;

    public Entrenador() {
        this.atletasAsignados = new ArrayList<>();
    }
    public Entrenador(String nombre, int experiencia) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.salario = 0.0;
        this.atletasAsignados = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSalario() {
        return salario;
    }
    // No es necesario el set
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public List<Atleta> getAtletasAsignados() {
        return atletasAsignados;
    }
    // no es necesario el set
    public void setAtletasAsignados(List<Atleta> atletasAsignados) {
        this.atletasAsignados = atletasAsignados;
    }

    @Override
    public double calcularSalario(){
        // Si años de experiencia es mayor a 3 incrementar el 5%
        final double SALARIO_BASE = 2000;

        if (experiencia >= 3){
            salario = SALARIO_BASE + (SALARIO_BASE * 0.05);
        }else {
            salario = SALARIO_BASE;
        }

        return salario;
    }
    @Override
    public void imprimir() {
        System.out.println("Entrenador: " + nombre);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Atletas asignados:");
        for (Atleta a : atletasAsignados) {
            System.out.println("- " + a.getNombre());
        }

    }
    // Metodos
    public boolean agregarAtleta(Atleta atleta) {
        if (atleta == null) return false;
        return this.atletasAsignados.add(atleta);
    }
    public String determinarObjetivoPlanEntrenamiento(Atleta atleta) {
        String objetivoPlan = "";
        if (atleta.getClasificacionIMC().equals("Bajo peso")){
            objetivoPlan = "Ganar masa muscular";
        } else if (atleta.getClasificacionIMC().equals("Peso normal")) {
            objetivoPlan = "Mejora de movilidad y estabilidad";
        } else if (atleta.getClasificacionIMC().equals("Sobrepeso")) {
            objetivoPlan = "Gasto calórico";
        } else if (atleta.getClasificacionIMC().equals("Obesidad")) {
            objetivoPlan = "Acondicionamiento metabólico";
        }
        return objetivoPlan;
    }
    public boolean preescribirPlanEntrenamiento(Atleta atleta, PlanEntrenamiento plan) {
        // enviarPlan a atleta
        if (atleta == null || plan == null) return false;
        return atleta.recibirPlanEntrenamiento(plan);
    }
    // enviar reporte
    public boolean enviarReporte(GestorReporte gestor, Reporte reporte) {
        if (gestor == null || reporte == null) return false;
        return gestor.guardarReportes(reporte);
    }

    // nuevo metodo
    public Atleta obtenerAtletaPorNombre(Atleta atleta) {
        for (Atleta a : atletasAsignados){
            if (a.getNombre().equals(atleta.getNombre())){
                return a;
            }
        }
        return null;
    }
}
