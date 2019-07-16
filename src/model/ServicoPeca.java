package model;

public class ServicoPeca {
    int id_servico, id_peca, quantidade;

    public ServicoPeca() {
    }

    public ServicoPeca(int id_servico, int id_peca, int quantidade) {
        this.id_servico = id_servico;
        this.id_peca = id_peca;
        this.quantidade = quantidade;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public int getId_peca() {
        return id_peca;
    }

    public void setId_peca(int id_peca) {
        this.id_peca = id_peca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
