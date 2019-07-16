package model;

public class Atendimento {
    String horario_atendimento, descricao_atendimento, placa_carro, data_atendimento;
    int id_atendimento, id_oficina;
    
    public Atendimento(){}

    public Atendimento(int id_atendimento, String horario_atendimento, String data_atendimento, String descricao_atendimento, int id_oficina, String placa_carro) {
        this.horario_atendimento = horario_atendimento;
        this.descricao_atendimento = descricao_atendimento;
        this.placa_carro = placa_carro;
        this.id_atendimento = id_atendimento;
        this.data_atendimento = data_atendimento;
        this.id_oficina = id_oficina;
    }

    public String getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(String horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }

    public String getDescricao_atendimento() {
        return descricao_atendimento;
    }

    public void setDescricao_atendimento(String descricao_atendimento) {
        this.descricao_atendimento = descricao_atendimento;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public String getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(String data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }
    
}


