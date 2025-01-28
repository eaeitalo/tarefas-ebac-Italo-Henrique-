package service;

import DAO.IProdutoDAO;
import domain.Produto;
import service.Generic.GenericService;

import java.util.Collection;

public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {
    private IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
        this.produtoDAO = dao;
    }

    @Override
    public Boolean salvar(Produto entity) {
        if (entity == null || entity.getId() == null) {
            return false;
        }
        return produtoDAO.salvar(entity);
    }

    @Override
    public Produto buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return produtoDAO.buscarPorId(id);
    }

    @Override
    public void excluir(Long id) {
        if (id != null) {
            produtoDAO.excluir(id);
        }
    }

    @Override
    public void alterar(Produto entity) {
        if (entity != null && entity.getId() != null) {
            produtoDAO.alterar(entity);
        }
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return produtoDAO.buscarTodos();
    }
}

