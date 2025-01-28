package DAO.Generic;

import domain.Identifiable;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericDAO<T extends Identifiable<E>, E extends Serializable> implements IGenericDAO<T, E> {
    private Map<E, T> database = new HashMap<>();

    @Override
    public Boolean salvar(T entity) {
        database.put(entity.getId(), entity); // Usa o ID da entidade como chave
        return true;
    }

    @Override
    public T buscarPorId(E id) {
        return database.get(id);
    }

    @Override
    public void excluir(E id) {
        database.remove(id);
    }

    @Override
    public void alterar(T entity) {
        database.put(entity.getId(), entity);
    }

    @Override
    public Collection<T> buscarTodos() {
        return database.values();
    }
}



