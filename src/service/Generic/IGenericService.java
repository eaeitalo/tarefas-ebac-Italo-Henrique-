package service.Generic;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService<T, E extends Serializable> {
    Boolean salvar(T entity);
    T buscarPorId(E id);
    void excluir(E id);
    void alterar(T entity);
    Collection<T> buscarTodos();
}

