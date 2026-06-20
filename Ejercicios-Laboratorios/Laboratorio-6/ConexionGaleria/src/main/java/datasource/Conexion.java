package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instancia;
    private Connection conexionBD;

    private static final String URL     = "jdbc:postgresql://localhost:5433/bd_galeria";
    private static final String USUARIO = "postgres";
    private static final String CLAVE   = "admin123";

    private Conexion() {
        conectar();
    }

    // Lógica de conexión separada para poder reconectar si se pierde
    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexionBD = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión establecida.");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    // FIX: reconecta automáticamente si la conexión expiró o se cerró
    public Connection getConexionBD() {
        try {
            if (conexionBD == null || conexionBD.isClosed()) {
                System.out.println("Reconectando...");
                conectar();
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar conexión: " + e.getMessage());
        }
        return conexionBD;
    }
}