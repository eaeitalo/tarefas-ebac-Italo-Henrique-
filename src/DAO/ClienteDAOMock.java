package DAO;

import domain.Cliente;

public class ClienteDAOMock implements IClienteDAO {

    @Override
    public Boolean salvar(Cliente cliente) {
        return true;

    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        return cliente;
    }

    @Override
    public void excluir(Long cpf) {

    }

    @Override
    public void alterar(Cliente cliente) {

    }
}
