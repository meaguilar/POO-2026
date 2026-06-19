package org.example.servicios;

import org.example.patrones.estrategia.visualizacion.Reporte;

import java.util.ArrayList;
import java.util.List;

public class GestorReporte {

    // Atributos
    private List<Reporte> reportes;

    // Constructores
    public GestorReporte() {
        reportes = new ArrayList<Reporte>();
    }
    public GestorReporte(List<Reporte> reporte) {
        this.reportes = reporte;
    }

    // Getter / Setter
    public List<Reporte> getReportes() {
        return reportes;
    }
    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    // Implementar la sincronización
    public synchronized boolean guardarReportes(Reporte reporte) {
        //return this.reportes.add(reporte);
        if (reporte == null) {
            return false;
        }else {
            this.reportes.add(reporte);
            return true;
        }
    }

}
