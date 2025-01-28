package ServiceTest;

import DAO.ProdutoDAO;
import domain.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ProdutoService;

import static org.junit.Assert.*;

public class ProdutosServiceTest {

    private ProdutoService produtoService;
    private ProdutoDAO produtoDAO;
    private Produto produto;

    @Before
    public void setUp() {
        produtoDAO = new ProdutoDAO();
        produtoService = new ProdutoService(produtoDAO);
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setPreco(100.0);
    }

    @Test
    public void testSalvarProduto() {
        Boolean resultado = produtoService.salvar(produto);
        Assert.assertTrue(resultado);
    }

    @Test
    public void testBuscarPorId() {
        produtoService.salvar(produto);
        Produto produtoRetornado = produtoService.buscarPorId(1L);
        Assert.assertNotNull(produtoRetornado);
        Assert.assertEquals("Produto Teste", produtoRetornado.getNome());
    }

    @Test
    public void testExcluirProduto() {
        produtoService.salvar(produto);
        produtoService.excluir(1L);
        Produto produtoExcluido = produtoService.buscarPorId(1L);
        Assert.assertNull(produtoExcluido);
    }

    @Test
    public void testAlterarProduto() {
        produtoService.salvar(produto);
        produto.setNome("Produto Alterado");
        produtoService.alterar(produto);
        Produto produtoAlterado = produtoService.buscarPorId(1L);
        Assert.assertNotNull(produtoAlterado);
        Assert.assertEquals("Produto Alterado", produtoAlterado.getNome());
    }
}



