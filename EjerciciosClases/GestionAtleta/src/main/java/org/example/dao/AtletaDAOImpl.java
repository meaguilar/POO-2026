package org.example.dao;

import org.example.bd.Conexion;
import org.example.modelo.Atleta;
import org.example.modelo.Nadador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AtletaDAOImpl implements AtletaDAO {

    // Definición de las consultas SQL para SQLSERVER y POSTGRESQL
    private static final String SQL_INSERT_ATLETA = "INSERT INTO ATLETA (nombre, edad, peso, altura, horas_entrenamiento_diarias, id_deporte, id_entrenador) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_NADADOR = "INSERT INTO NADADOR (id_atleta, estilo) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE ATLETA SET nombre = ?, edad = ?, deporte = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM ATLETA WHERE id = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM ATLETA WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ATLETA";

    public boolean guardar(Atleta a, int idEntrenador) {

        // Establecer la conexion
        Conexion.getInstancia().conectar();

        // Implementar try..resources .. para cerrar automatico todos los recursos
        try(Connection connection = Conexion.getInstancia().getConexionBD()) {
            // Implementar rollback
            connection.setAutoCommit(false);

            try(PreparedStatement psAtleta = connection.prepareStatement(SQL_INSERT_ATLETA, java.sql.Statement.RETURN_GENERATED_KEYS);
            PreparedStatement psNadador = connection.prepareStatement(SQL_INSERT_NADADOR)) {

                // Mapear los datos del atleta
                psAtleta.setString(1, a.getNombre());
                psAtleta.setInt(2, a.getEdad());
                psAtleta.setDouble(3, a.getPeso());
                psAtleta.setDouble(4, a.getAltura());

                // Convertir el arreglo en String - SQLSERVER No soporta Arreglo
                String horasEntrenamiento = (a.getHorasEntrenamientodiarias() != null)
                        ? java.util.Arrays.stream(a.getHorasEntrenamientodiarias())
                        .mapToObj(String::valueOf)
                        .collect(java.util.stream.Collectors.joining(","))
                        : "";
                psAtleta.setString(5, horasEntrenamiento);

                   // Mapear las horas de entrenamiento POSTGRESQL Soporte arreglos

          /*      Double[] horasJava = a.getHorasEntrenamientoDiarias();

                // Convertir el arreglo de Java al tipo "float8" de PostgreSQL (float8 equivale a DOUBLE PRECISION / FLOAT)
                java.sql.Array horasSQL = connection.createArrayOf("float8", horasJava);

                psAtleta.setArray(5, horasSQL);*/


                psAtleta.setInt(6, a.getDeporte().getId());

                psAtleta.setInt(7, idEntrenador);

                // Verificar si se insertó el Atleta
                if (psAtleta.executeUpdate() == 0) {
                    connection.rollback();
                    return false;
                }

                // Recuperar ID autogenerado
                int idAtleta = 0;
                try (java.sql.ResultSet rs = psAtleta.getGeneratedKeys()) {
                    if (rs.next()) {
                        idAtleta = rs.getInt(1);
                    }
                }

                // Evalúa y crea la variable 'nadador'
                if(a instanceof Nadador nadador) {
                    psNadador.setInt(1, idAtleta);
                    psNadador.setString(2, nadador.getEstilo());
                    psNadador.executeUpdate();
                }
                // Si se agregan más atletas, extender :
                // else if (a instanceof Futbolista futbolista) { ... }

                // Confirmar la transaccion completa
                connection.commit();
                return true;

            } catch (SQLException e) {
                connection.rollback();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            Conexion.getInstancia().desconectar();
        }
    }

    public boolean actualizar(Atleta a) {
        return false;
    }

    public boolean eliminar(int id) {
        return false;
    }

    public Atleta buscarPorId(int id) {
        return null;
    }

    public List<Atleta> listarTodos() {
        return null;
    }

}
