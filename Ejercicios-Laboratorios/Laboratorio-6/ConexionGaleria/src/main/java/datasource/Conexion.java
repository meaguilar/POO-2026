package datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Singleton que mantiene la unica conexion JDBC con PostgreSQL.
 * Si la conexion se cierra, la reabre automaticamente la proxima vez
 * que se pida. Lee URL/usuario/clave de db.properties o usa defaults.
 */
public class Conexion {

    private static Conexion instancia;
    private Connection conexionBD;
    private String url;
    private String usuario;
    private String clave;

    private Conexion() {
        cargarConfiguracion();
        conectar();
    }

    /**
     * Lee db.properties del classpath o, si no, del sistema de archivos.
     */
    private void cargarConfiguracion() {
        Properties props = new Properties();
        try (InputStream is = getClass().getResourceAsStream("/db.properties")) {
            if (is != null) {
                props.load(is);
            } else {
                try (FileInputStream fis = new FileInputStream("src/main/resources/db.properties")) {
                    props.load(fis);
                }
            }
        } catch (IOException e) {
            System.err.println("No se encontro db.properties, usando valores por defecto.");
        }
        this.url = props.getProperty("db.url", "jdbc:postgresql://localhost:5433/bd_galeria");
        this.usuario = props.getProperty("db.user", "postgres");
        this.clave = props.getProperty("db.password", "admin123");
    }

    /**
     * Abre la conexion: carga el driver PostgreSQL y la pide a DriverManager.
     */
    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexionBD = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion establecida con PostgreSQL: " + url);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver de PostgreSQL no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }

    /**
     * Devuelve la unica instancia (lazy, sin sincronizacion).
     */
    public static Conexion getInstancia() {
        if (instancia == null) instancia = new Conexion();
        return instancia;
    }

    /**
     * Devuelve una conexion valida; la reabre si se cerro.
     */
    public Connection getConexionBD() {
        try {
            if (conexionBD == null || conexionBD.isClosed()) {
                System.out.println("Reconectando...");
                conectar();
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar conexion: " + e.getMessage());
        }
        return conexionBD;
    }
}
