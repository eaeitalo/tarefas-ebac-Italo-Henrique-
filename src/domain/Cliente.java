package domain;

public class Cliente {
    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer num;
    private String cidade;
    private String estado;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Long getTel() {
        return tel;
    }

    public String getEnd() {
        return end;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estadp) {
        this.estado = estadp;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
