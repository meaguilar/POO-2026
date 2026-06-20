package dao;

import model.Arte;
import java.util.List;

public interface ArteDAO {
    boolean guardar(Arte arte);
    boolean actualizar(Arte arte);
    boolean eliminar(int idArte);
    Arte buscarPorId(int idArte);
    Arte buscarPorNombre(String nombreArte);
    List<Arte> listarTodos();
}