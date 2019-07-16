package model;

public class Servico {
    String descricao_servico, placa_carro;
    int id_servico, id_oficina, tempo_est_dias;
    Float preco_servico;
    
    public Servico(){}

    public Servico(int id_servico, Float preco_servico, int tempo_est_dias, String descricao_servico, int id_oficina, String placa_carro) {
        this.descricao_servico = descricao_servico;
        this.placa_carro = placa_carro;
        this.id_servico = id_servico;
        this.id_oficina = id_oficina;
        this.tempo_est_dias = tempo_est_dias;
        this.preco_servico = preco_servico;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public int getTempo_est_dias() {
        return tempo_est_dias;
    }

    public void setTempo_est_dias(int tempo_est_dias) {
        this.tempo_est_dias = tempo_est_dias;
    }

    public Float getPreco_servico() {
        return preco_servico;
    }

    public void setPreco_servico(Float preco_servico) {
        this.preco_servico = preco_servico;
    }
    
    
}
