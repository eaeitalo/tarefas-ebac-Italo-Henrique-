package DAOTest;

import DAO.Generic.GenericDAO;
import domain.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GenericDAOTest {

    private GenericDAO<Produto, Long> produtoDAO;
    private Produto produto;

    @Before
    public void setUp() {
        produtoDAO = new GenericDAO<>();
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
    }

    @Test
    public void testSalvar() {
        produtoDAO.salvar(produto);
        Produto produtoSalvo = produtoDAO.buscarPorId(1L);
        Assert.assertNotNull(produtoSalvo);
        Assert.assertEquals("Produto Teste", produtoSalvo.getNome());
    }

    @Test
    public void testExcluir() {
        produtoDAO.salvar(produto);
        produtoDAO.excluir(1L);
        Produto produtoExcluido = produtoDAO.buscarPorId(1L);
        Assert.assertNull(produtoExcluido);
    }

    @Test
    public void testAlterar() {
        produtoDAO.salvar(produto);
        produto.setNome("Produto Alterado");
        produtoDAO.alterar(produto);
        Produto produtoAlterado = produtoDAO.buscarPorId(1L);
        Assert.assertEquals("Produto Alterado", produtoAlterado.getNome());
    }

    @Test
    public void testBuscarTodos() {
        produtoDAO.salvar(produto);
        Collection<Produto> produtos = produtoDAO.buscarTodos();
        Assert.assertFalse(((Collection<?>) produtos).isEmpty());
        Assert.assertTrue(produtos.contains(produto));
    }
}






