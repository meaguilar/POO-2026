package org.example.util;

import org.example.bd.Conexion;

import java.sql.Connection;

public class ConexionPrueba {
    // Metodo estático de prueba
    public static void probarConexion() {

        Conexion conexion = Conexion.getInstancia();
        conexion.conectar();
        Connection conn = conexion.getConexionBD();

        if (conn != null) {
            try {
                System.out.println("Conexión activa: " + !conn.isClosed());
            } catch (Exception e) {
                System.out.println("Error verificando conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo conectar");
        }

        conexion.desconectar();
    }
}
