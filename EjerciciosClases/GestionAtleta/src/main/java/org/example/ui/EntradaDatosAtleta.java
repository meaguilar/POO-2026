package org.example.ui;

import org.example.modelo.Atleta;
import org.example.modelo.Nadador;

import java.util.Scanner;


public class EntradaDatosAtleta {

    private final Scanner sc;

    public EntradaDatosAtleta(Scanner sc) {
        this.sc = sc;
    }

    private void leerDatosBase(Atleta a) {
        System.out.print("Nombre: ");
        a.setNombre(sc.nextLine());

        System.out.print("Peso: ");
        a.setPeso(sc.nextDouble());

        System.out.print("Altura: ");
        a.setAltura(sc.nextDouble());
        sc.nextLine();
    }

    public Nadador ingresarNadador() {
        Nadador n = new Nadador();

        leerDatosBase(n);

        System.out.print("Estilo: ");
        n.setEstilo(sc.nextLine());

        return n;
    }
}
