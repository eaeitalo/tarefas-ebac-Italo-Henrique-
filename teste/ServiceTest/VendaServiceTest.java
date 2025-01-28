package ServiceTest;

import domain.Cliente;
import domain.Venda;
import DAO.VendaDAO;
import org.junit.Assert;
import service.VendaService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import domain.Venda;
import domain.Cliente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendaServiceTest {

    private VendaService vendaService;
    private VendaDAO vendaDAO;
    private Venda venda;

    @Before
    public void setUp() {
        vendaDAO = new VendaDAO();
        vendaService = new VendaService(vendaDAO);
        venda = new Venda();
        venda.setId(1L);
        venda.setCliente(new Cliente()); // Cliente válido
    }

    @Test
    public void testSalvarVenda() {
        Boolean resultado = vendaService.salvar(venda);
        Assert.assertTrue(resultado);
    }

    @Test
    public void testBuscarPorId() {
        vendaService.salvar(venda);
        Venda vendaRetornada = vendaService.buscarPorId(1L);
        Assert.assertNotNull(vendaRetornada);
    }
}

