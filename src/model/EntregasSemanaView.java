package model;

public class EntregasSemanaView {
    String placa_carro, data_atendimento, data_entrega;
    int tempo_est_total;

    public EntregasSemanaView() {
    }

    public EntregasSemanaView(String placa_carro, String data_atendimento, String data_entrega, int tempo_est_total) {
        this.placa_carro = placa_carro;
        this.data_atendimento = data_atendimento;
        this.data_entrega = data_entrega;
        this.tempo_est_total = tempo_est_total;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public String getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(String data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public int getTempo_est_total() {
        return tempo_est_total;
    }

    public void setTempo_est_total(int tempo_est_total) {
        this.tempo_est_total = tempo_est_total;
    }
    
    
}
