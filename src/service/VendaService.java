package service;

import DAO.IVendaDAO;
import domain.Venda;
import service.Generic.GenericService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    private Map<Long, Venda> database = new HashMap<>();

    public VendaService(IVendaDAO dao) {
        super(dao);
    }

    @Override
    public Boolean salvar(Venda entity) {
        if (entity != null && entity.getId() != null) {
            database.put(entity.getId(), entity);
            return true;
        }
        return false;
    }

    @Override
    public Venda buscarPorId(Long id) {
        return database.get(id);
    }

    @Override
    public void excluir(Long id) {
        database.remove(id);
    }

    @Override
    public void alterar(Venda entity) {
        if (entity != null && entity.getId() != null) {
            database.put(entity.getId(), entity);
        }
    }

    @Override
    public Collection<Venda> buscarTodos() {
        return database.values();
    }
}


