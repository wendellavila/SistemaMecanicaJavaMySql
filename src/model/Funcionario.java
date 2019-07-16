package model;

public class Funcionario {
    String cpf_funconario, nome_funcionario;
    int id_oficina;

    public Funcionario() {
    }

    public Funcionario(String cpf_funconario, String nome_funcionario, int id_oficina) {
        this.cpf_funconario = cpf_funconario;
        this.nome_funcionario = nome_funcionario;
        this.id_oficina = id_oficina;
    }

    public String getCpf_funcionario() {
        return cpf_funconario;
    }

    public void setCpf_funcionario(String cpf_funconario) {
        this.cpf_funconario = cpf_funconario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }
    
    
}
