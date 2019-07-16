package model;

public class Peca {
    int id_peca;
    String nome_peca;
    Float preco_peca;

    public Peca() {
    }

    public Peca(int id_peca, String nome_peca, Float preco_peca) {
        this.id_peca = id_peca;
        this.nome_peca = nome_peca;
        this.preco_peca = preco_peca;
    }

    public int getId_peca() {
        return id_peca;
    }

    public void setId_peca(int id_peca) {
        this.id_peca = id_peca;
    }

    public String getNome_peca() {
        return nome_peca;
    }

    public void setNome_peca(String nome_peca) {
        this.nome_peca = nome_peca;
    }

    public Float getPreco_peca() {
        return preco_peca;
    }

    public void setPreco_peca(Float preco_peca) {
        this.preco_peca = preco_peca;
    }
    
    
}
