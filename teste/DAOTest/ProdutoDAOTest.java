package DAOTest;

import DAO.ProdutoDAO;
import domain.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoDAOTest {

    private ProdutoDAO produtoDAO;
    private Produto produto;

    @Before
    public void setUp() {
        produtoDAO = new ProdutoDAO();
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setPreco(100.0);
    }

    @Test
    public void testSalvarProduto() {
        Boolean resultado = produtoDAO.salvar(produto);
        Assert.assertTrue(resultado);

        Produto produtoSalvo = produtoDAO.buscarPorId(1L);
        Assert.assertNotNull(produtoSalvo);
        Assert.assertEquals("Produto Teste", produtoSalvo.getNome());
        Assert.assertEquals(100.0, produtoSalvo.getPreco(), 0.01);
    }

    @Test
    public void testBuscarPorId() {
        produtoDAO.salvar(produto);
        Produto produtoRetornado = produtoDAO.buscarPorId(1L);
        Assert.assertNotNull(produtoRetornado);
        Assert.assertEquals("Produto Teste", produtoRetornado.getNome());
    }

    @Test
    public void testExcluirProduto() {
        produtoDAO.salvar(produto);
        produtoDAO.excluir(1L);

        Produto produtoExcluido = produtoDAO.buscarPorId(1L);
        Assert.assertNull(produtoExcluido);
    }

    @Test
    public void testAlterarProduto() {
        produtoDAO.salvar(produto);
        produto.setNome("Produto Alterado");
        produtoDAO.alterar(produto);

        Produto produtoAlterado = produtoDAO.buscarPorId(1L);
        Assert.assertNotNull(produtoAlterado);
        Assert.assertEquals("Produto Alterado", produtoAlterado.getNome());
    }
}



