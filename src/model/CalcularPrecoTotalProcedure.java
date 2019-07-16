package model;

public class CalcularPrecoTotalProcedure {
    int id_procedimento;
    Float preco_total_servico;

    public CalcularPrecoTotalProcedure() {
    }

    public CalcularPrecoTotalProcedure(int id_procedimento, Float preco_total_servico) {
        this.id_procedimento = id_procedimento;
        this.preco_total_servico = preco_total_servico;
    }

    public int getId_procedimento() {
        return id_procedimento;
    }

    public void setId_procedimento(int id_procedimento) {
        this.id_procedimento = id_procedimento;
    }

    public Float getPreco_total_servico() {
        return preco_total_servico;
    }

    public void setPreco_total_servico(Float preco_total_servico) {
        this.preco_total_servico = preco_total_servico;
    }
    
    
}
