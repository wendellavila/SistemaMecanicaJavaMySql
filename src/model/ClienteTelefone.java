package model;

public class ClienteTelefone {
    private String cpf, telefone;
    
    public ClienteTelefone(){}
    
    public ClienteTelefone(String cpf, String telefone) {
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
