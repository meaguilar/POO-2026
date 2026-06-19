package org.example.dao;

import org.example.modelo.Atleta;

import java.util.List;

public interface AtletaDAO {

    boolean guardar(Atleta a, int idEntrenador);
    boolean actualizar(Atleta a);
    boolean eliminar(int id);
    Atleta buscarPorId(int id);
    List<Atleta> listarTodos();

}
