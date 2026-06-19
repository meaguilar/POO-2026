package org.example.ui;

import org.example.catalogo.Deporte;
import org.example.hilos.EntrenamientoAtleta;
import org.example.hilos.EvaluacionEntrenamiento;
import org.example.modelo.*;
import org.example.patrones.estrategia.conversion.ConversionDolarEuro;
import org.example.patrones.estrategia.conversion.ConversionDolarPesosMexicanos;
import org.example.patrones.estrategia.conversion.EstrategiaConversionMoneda;
import org.example.patrones.estrategia.conversion.Planilla;
import org.example.patrones.estrategia.visualizacion.EstrategiaVisualizacion;
import org.example.patrones.estrategia.visualizacion.Reporte;
import org.example.patrones.estrategia.visualizacion.VisualizacionCompleta;
import org.example.patrones.estrategia.visualizacion.VisualizacionSimple;
import org.example.servicios.GestorReporte;

import java.time.LocalDate;

public class DatosQuemados {

    public static void cargarDatos() {
        System.out.println("Cargando datos...");

        Nadador nadador1 = new Nadador("Florencia", 20, Deporte.NATACION,
                55, 1.70, new double[]{2, 4, 6, 7, 3, 5, 2},
                0.0, 0.0, "Mariposa");

        nadador1.imprimir();
        // estableciendo el promHorasCalculadas
        nadador1.setPromHorasEntrenamiento(nadador1.calcularPromedioSemanalEntrenamiento());
        // Nuevo estilo de nado
        nadador1.cambiarEstilo("Libre (Crol)");
        // estableciendo el imc calculado
        nadador1.setImc(nadador1.calcularIMC());
        System.out.println("IMC actual: " + nadador1.getImc());
        // establenciendo la nueva clasificacion de IMC
        nadador1.setClasificacionIMC(nadador1.clasificarIMC());
        System.out.println("Clasificación IMC: " + nadador1.getClasificacionIMC());

        System.out.print("Clasificación del rendimiento: ");
        nadador1.clasificarRendimiento();
        nadador1.entrenar();

        // segundo atleta
        Nadador nadador2 = new Nadador();
        nadador2.setNombre("Karla");


        System.out.print("\nEquipos\n");
        // Creando el equipo
        Equipo equipo1 = new Equipo();
        equipo1.setNombre("Equipo1");
        equipo1.agregarMiembrosEquipo(nadador1);
        equipo1.agregarMiembrosEquipo(nadador2);
        equipo1.imprimir();


        System.out.print("\nDatos entrenador\n");
        Entrenador entrenador1 = new Entrenador("Julio", 4);
        entrenador1.calcularSalario();

        // Crear entrenador2
        Entrenador entrenador2 = new Entrenador("Roxana", 5);

        // asignar atletas
        entrenador1.agregarAtleta(nadador1);
        entrenador1.agregarAtleta(nadador2);
        entrenador2.agregarAtleta(nadador1);

        entrenador1.imprimir();


        // Crear la planilla
        Planilla planilla1 = new Planilla();
        // Crear la referencia del pago del entrenador
        Pagable pago = entrenador1;
        // Asignador la referencia del pago  a la planilla
        planilla1.setPago(pago);
        // Conversion de salario
        EstrategiaConversionMoneda pesosMx = new ConversionDolarPesosMexicanos();
        EstrategiaConversionMoneda euros = new ConversionDolarEuro();
        // Estableciendo la estrategia
        planilla1.setEstrategia(pesosMx);
        //planilla1.setEstrategia(euros);

        // Detalles del salario del entrenador
        System.out.println("\n Salario del entrenador en diferentes moneadas: ");
        // Salario calculado segun experiencia
        System.out.println("Salario según exp. $" + pago.calcularSalario());
        // Imprimiendo el salario en diferentes monedas
        System.out.println("Salario según exp. pesos Mx: " + planilla1.convertirSalario());
        //System.out.println("Salario según exp. euros: " + planilla1.convertirSalario());

        //Determinar el objetivo del plan de entrenamiento
        String objetivoPlan = entrenador1.determinarObjetivoPlanEntrenamiento(nadador1);

        // Crear el plan de entrenamiento
        PlanEntrenamiento planEntrenamiento1 = new PlanEntrenamiento();
        planEntrenamiento1.setObjetivo(objetivoPlan);
        System.out.println(" \n-Objetivo del plan: " + planEntrenamiento1.getObjetivo() + " - atleta: " + nadador1.getNombre());
        planEntrenamiento1.agregarEjercicio("Sentadillas con pesas", 0.3);
        planEntrenamiento1.agregarEjercicio("Press de banca", 0.5);

        // preescribir plan de entrenamiento al atleta
        boolean asignado = entrenador1.preescribirPlanEntrenamiento(nadador1, planEntrenamiento1);
        if (asignado) {
            System.out.println("\nPlan asignado correctamente al atleta: " + nadador1.getNombre());
        } else {
            System.out.println("Error al asignar el plan al atleta: " + nadador1.getNombre());
        }


        // Imprimiendo el plan de entrenamiento por el nadador
        System.out.println("Detalles del plan entrenamiento: " + nadador1.getNombre());
        nadador1.getPlanActual().imprimir();

        //Creando el reporte
        Reporte reporte1 = new Reporte();
        reporte1.setAsunto("Primer Reporte del mes");
        reporte1.setFecha(LocalDate.now());

        // Enviando reporte por entrenador1
        GestorReporte gestorReporte1 = new GestorReporte();
        entrenador1.enviarReporte(gestorReporte1, reporte1);


        // visualizando el reporte aplicando el patron strategy
        EstrategiaVisualizacion estrategiaReporteCompleto = new VisualizacionCompleta();
        EstrategiaVisualizacion estrategiaReporteSimple = new VisualizacionSimple();
        reporte1.setEstrategia(estrategiaReporteCompleto);
        reporte1.visualizar();

        // Imprimir el listado de los reportes desde el gestor
        System.out.println("\nListado de reportes ");
        for (Reporte reporte : gestorReporte1.getReportes()) {
            System.out.println("Detalles del reportes: ");
            System.out.println("Asunto " + reporte.getAsunto());
            System.out.println("Fecha " + reporte.getFecha());
        }

        // CREAR EL REPORTE DE LA EVALUACION -- gestor asociado gestor1
        Reporte reporteEvaluacion = new Reporte();
        reporteEvaluacion.setFecha(LocalDate.now());
        reporteEvaluacion.setAsunto("Evaluación deportiva  \n");
        entrenador1.enviarReporte(gestorReporte1, reporteEvaluacion);

        // Crear tareas concurrentes y en paralelo
        Thread hiloEntrenamiento = new Thread(new EntrenamientoAtleta(nadador1));
        Thread hiloEvaluacionEntrenador1 = new Thread(new EvaluacionEntrenamiento(nadador1, entrenador1, gestorReporte1, reporteEvaluacion));
        Thread hiloEvaluacionEntrenador2 = new Thread(new EvaluacionEntrenamiento(nadador1, entrenador2, gestorReporte1, reporteEvaluacion));

        // Ejecutar los hilos
        hiloEntrenamiento.start();
        hiloEvaluacionEntrenador1.start();
        hiloEvaluacionEntrenador2.start();

        try {
            // Controlar la ejecución de los hilos
            hiloEntrenamiento.join();
            hiloEvaluacionEntrenador1.join();
            hiloEvaluacionEntrenador2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reporteEvaluacion.firmarReporte("Reporte oficial autorizado. F:[Gimnasio UCA]");

        // Imprimir los reportes del entrenador 1 con la estrategia de reporte completo
        System.out.println("\nListado de reportes ");
        reporteEvaluacion.setEstrategia(estrategiaReporteCompleto);
        reporteEvaluacion.visualizar();


    }

}
