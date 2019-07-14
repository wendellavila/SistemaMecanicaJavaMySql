package model;

public class Carro {
    private String chassi, ano, placa, modelo, marca;
    
    public Carro(){}

    public Carro(String chassi, String ano, String placa, String modelo, String marca) {
        this.chassi = chassi;
        this.ano = ano;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
