package model;

public class AtendimentoServico {
    int id_atendimento, id_servico;

    public AtendimentoServico() {
    }

    public AtendimentoServico(int id_atendimento, int id_servico) {
        this.id_atendimento = id_atendimento;
        this.id_servico = id_servico;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }
    
}
