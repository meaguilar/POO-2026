package org.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Instancia única (Singleton)
    private static Conexion instancia;

    // Objeto JDBC Connection
    private Connection conexionBD;
    //private static final String URL = "jdbc:postgresql://localhost:5432/BD_ATLETAS";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BD_ATLETAS;encrypt=false";
    private static final String USUARIO = "sa";
    private static final String CLAVE = "TuPassword123!";

    // Constructor privado (clave del Singleton)
    private Conexion() {}

    // Obtener instancia única
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    // Obtener la conexion activa
    public Connection getConexionBD() {
        return conexionBD;
    }

    public void conectar() {
        try {
            if (conexionBD == null || conexionBD.isClosed()) {
                conexionBD = DriverManager.getConnection(URL, USUARIO, CLAVE);
                System.out.println("Conexión a la base de datos establecida.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public void desconectar() {
        try {
            if (conexionBD != null) {
                conexionBD.close();
                conexionBD = null;
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }

}
