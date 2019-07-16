package model;

public class PrecoTotalPecasView {
    int id_atendimento;
    String placa_carro;
    Float preco_total_pecas;

    public PrecoTotalPecasView() {
    }

    public PrecoTotalPecasView(int id_atendimento, String placa_carro, Float preco_total_pecas) {
        this.id_atendimento = id_atendimento;
        this.placa_carro = placa_carro;
        this.preco_total_pecas = preco_total_pecas;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public Float getPreco_total_pecas() {
        return preco_total_pecas;
    }

    public void setPreco_total_pecas(Float preco_total_pecas) {
        this.preco_total_pecas = preco_total_pecas;
    }
    
    
}
