package org.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Imprimible{

    String nombre;
    // Colección lista
    List<Atleta> miembrosEquipo;

    public Equipo() {
        this.miembrosEquipo = new ArrayList<>();
    }

    public Equipo(String nombre, List<Atleta> miembrosEquipo) {
        this.nombre = nombre;
        this.miembrosEquipo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Atleta> getMiembrosEquipo() {
        return miembrosEquipo;
    }
    // No necesario el metodo setter
    public void setMiembrosEquipo(List<Atleta> miembrosEquipo) {
        this.miembrosEquipo = miembrosEquipo;
    }

    // Agregar atletas a la lista
    public boolean agregarMiembrosEquipo(Atleta atleta) {
        if (atleta == null) return false;
        return this.miembrosEquipo.add(atleta);
    }

    // Imprimir
    @Override
    public void imprimir() {
        System.out.println("Nombre del equipo: " + this.nombre);
        System.out.println("Miembros del equipo:");
        for (Atleta a : miembrosEquipo) {
            System.out.println("- " + a.getNombre());
        }
    }

}
