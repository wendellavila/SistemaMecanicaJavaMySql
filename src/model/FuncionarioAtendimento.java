package model;

public class FuncionarioAtendimento {
    String cpf_funcionario;
    int id_atendimento;

    public FuncionarioAtendimento() {
    }

    public FuncionarioAtendimento(String cpf_funcionario, int id_atendimento) {
        this.cpf_funcionario = cpf_funcionario;
        this.id_atendimento = id_atendimento;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }
    
}
