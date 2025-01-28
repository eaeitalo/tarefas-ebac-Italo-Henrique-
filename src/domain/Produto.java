package domain;

public class Produto implements Persistente<Long>, Identifiable<Long> {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Double preco;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}




