package model;

public class FuncionarioServico {
    String cpf_funcionario;
    int id_servico;

    public FuncionarioServico() {
    }

    public FuncionarioServico(String cpf_funcionario, int id_servico) {
        this.cpf_funcionario = cpf_funcionario;
        this.id_servico = id_servico;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }
    
}
