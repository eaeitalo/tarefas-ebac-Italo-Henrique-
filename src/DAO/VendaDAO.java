package DAO;

import DAO.Generic.GenericDAO;
import domain.Venda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

    private Map<Long, Venda> database = new HashMap<>();

    @Override
    public Boolean salvar(Venda venda) {
        if (venda == null || venda.getId() == null) {
            return false;
        }
        database.put(venda.getId(), venda);
        return true;
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
    public void alterar(Venda venda) {
        if (venda != null && venda.getId() != null) {
            database.put(venda.getId(), venda);
        }
    }

    @Override
    public Collection<Venda> buscarTodos() {
        return database.values();
    }
}


