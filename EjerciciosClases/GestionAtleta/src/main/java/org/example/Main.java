package org.example;

import org.example.modelo.Atleta;
import org.example.ui.Consola;
import org.example.ui.DatosQuemados;
import org.example.ui.EntradaDatosAtleta;


public class Main {
    public static void main(String[] args) {

        DatosQuemados.cargarDatos();

        // Ingreso de datos por consola
//        EntradaDatosAtleta entradaDatosAtleta = new EntradaDatosAtleta(Consola.getScanner());
//        Atleta nadador3 = entradaDatosAtleta.ingresarNadador();
//        System.out.println("Datos ingresado del nadador " + nadador3.getNombre());

    }
}
