package dao;

import datasource.Conexion;
import model.Arte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArteDAOImpl implements ArteDAO {

    private final Conexion conexion;

    public ArteDAOImpl() {
        this.conexion = Conexion.getInstancia();
    }

    @Override
    public boolean guardar(Arte arte) {
        String sql = "INSERT INTO arte (nombre_arte, url_arte) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.getConexionBD().prepareStatement(sql)) {
            stmt.setString(1, arte.getNombreArte());
            stmt.setString(2, arte.getUrlArte());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Arte arte) {
        String sql = "UPDATE arte SET nombre_arte = ?, url_arte = ? WHERE id_arte = ?";
        try (PreparedStatement stmt = conexion.getConexionBD().prepareStatement(sql)) {
            stmt.setString(1, arte.getNombreArte());
            stmt.setString(2, arte.getUrlArte());
            stmt.setInt(3, arte.getIdArte());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idArte) {
        String sql = "DELETE FROM arte WHERE id_arte = ?";
        try (PreparedStatement stmt = conexion.getConexionBD().prepareStatement(sql)) {
            stmt.setInt(1, idArte);
            // FIX: verificar filas afectadas, antes siempre retornaba true
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Arte buscarPorId(int idArte) {
        String sql = "SELECT id_arte, nombre_arte, url_arte FROM arte WHERE id_arte = ?";
        try (PreparedStatement stmt = conexion.getConexionBD().prepareStatement(sql)) {
            stmt.setInt(1, idArte);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Arte(rs.getInt("id_arte"), rs.getString("nombre_arte"), rs.getString("url_arte"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por id: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Arte buscarPorNombre(String nombreArte) {
        String sql = "SELECT id_arte, nombre_arte, url_arte FROM arte " +
                "WHERE LOWER(TRIM(nombre_arte)) = LOWER(TRIM(?)) LIMIT 1";
        try (PreparedStatement stmt = conexion.getConexionBD().prepareStatement(sql)) {
            stmt.setString(1, nombreArte);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Arte(rs.getInt("id_arte"), rs.getString("nombre_arte"), rs.getString("url_arte"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por nombre: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Arte> listarTodos() {
        List<Arte> lista = new ArrayList<>();
        String sql = "SELECT id_arte, nombre_arte, url_arte FROM arte";
        try (Statement stmt = conexion.getConexionBD().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Arte(
                        rs.getInt("id_arte"),
                        rs.getString("nombre_arte"),
                        rs.getString("url_arte")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
}