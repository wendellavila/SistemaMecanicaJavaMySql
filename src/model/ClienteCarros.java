package model;

public class ClienteCarros {
    private String cpf, placa;
    
    public ClienteCarros(){}
    
    public ClienteCarros(String cpf, String placa) {
        this.cpf = cpf;
        this.placa = placa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
