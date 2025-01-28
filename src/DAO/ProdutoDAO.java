package DAO;

import DAO.Generic.GenericDAO;
import domain.Produto;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

    private Map<Long, Produto> database = new HashMap<>();

    @Override
    public Boolean salvar(Produto produto) {
        if (produto == null || produto.getId() == null) {
            return false;
        }
        database.put(produto.getId(), produto);
        return true;
    }

    @Override
    public Produto buscarPorId(Long id) {
        return database.get(id);
    }

    @Override
    public void excluir(Long id) {
        database.remove(id);
    }

    @Override
    public void alterar(Produto produto) {
        if (produto != null && produto.getId() != null) {
            database.put(produto.getId(), produto);
        }
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return database.values();
    }
}

