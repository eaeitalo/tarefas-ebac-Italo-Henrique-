package DAOTest;

import DAO.ClienteDAOMock;
import DAO.IClienteDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import domain.Cliente;

public class ClientDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClientDAOTest() {
        clienteDAO = new ClienteDAOMock();
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

        clienteDAO.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDAO.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() {
        Boolean retorno = clienteDAO.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() {
        cliente.setNome("Oliver Queen");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Oliver Queen", cliente.getNome());
    }
}
