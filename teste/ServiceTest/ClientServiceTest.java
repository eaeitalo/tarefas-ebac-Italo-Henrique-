package ServiceTest;

import DAO.ClienteDAOMock;
import DAO.IClienteDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import domain.Cliente;
import service.ClienteService;
import service.IClienteService;

public class ClientServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClientServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(123456789L);
        cliente.setNome("Oliver");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Endereço");
        cliente.setEstado("MG");
        cliente.setNum(2);
        cliente.setTel(123456789L);

        clienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() {
        cliente.setNome("Oliver Queen");
        clienteService.alterar(cliente);

        Assert.assertEquals("Oliver Queen", cliente.getNome());
    }

}
