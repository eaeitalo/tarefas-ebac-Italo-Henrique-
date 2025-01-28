package domain;

import java.io.Serializable;

public class Venda implements Identifiable<Long>, Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Cliente cliente;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}


