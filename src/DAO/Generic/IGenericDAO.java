package DAO.Generic;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO<T, E extends Serializable> {
    Boolean salvar(T entity);
    T buscarPorId(E id);
    void excluir(E id);
    void alterar(T entity);
    Collection<T> buscarTodos();
}

