package DAOTest;

import DAO.VendaDAO;
import domain.Cliente;
import domain.Venda;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendaDAOTest {

    private VendaDAO vendaDAO;
    private Venda venda;

    @Before
    public void setUp() {
        vendaDAO = new VendaDAO();
        venda = new Venda();
        venda.setId(1L);
        venda.setCliente(new Cliente());
    }

    @Test
    public void testSalvarVenda() {
        Boolean resultado = vendaDAO.salvar(venda);
        Assert.assertTrue(resultado);
        Venda vendaSalva = vendaDAO.buscarPorId(1L);
        Assert.assertNotNull(vendaSalva);
    }

    @Test
    public void testExcluirVenda() {
        vendaDAO.salvar(venda);
        vendaDAO.excluir(1L);
        Venda vendaExcluida = vendaDAO.buscarPorId(1L);
        Assert.assertNull(vendaExcluida);
    }
}


