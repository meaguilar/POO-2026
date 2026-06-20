package dao;

import model.Arte;

import java.util.List;

/**
 * Contrato CRUD para la entidad Arte. Desacopla la UI de la tecnologia
 * de persistencia (PostgreSQL, MySQL, mock, etc.).
 */
public interface ArteDAO {
    boolean guardar(Arte arte);

    boolean actualizar(Arte arte);

    boolean eliminar(int idArte);

    Arte buscarPorId(int idArte);

    Arte buscarPorNombre(String nombreArte);  // case-insensitive, LIMIT 1

    List<Arte> listarTodos();
}
