package service.Generic;

import DAO.Generic.IGenericDAO;

import java.io.Serializable;
import java.util.Collection;

public class GenericService<T, E extends Serializable> implements IGenericService<T, E> {
    private IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean salvar(T entity) {
        return dao.salvar(entity);
    }

    @Override
    public T buscarPorId(E id) {
        return dao.buscarPorId(id);
    }

    @Override
    public void excluir(E id) {
        dao.excluir(id);
    }

    @Override
    public void alterar(T entity) {
        dao.alterar(entity);
    }

    @Override
    public Collection<T> buscarTodos() {
        return dao.buscarTodos();
    }
}

