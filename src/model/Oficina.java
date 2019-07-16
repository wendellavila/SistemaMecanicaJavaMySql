package model;

public class Oficina {
    int id_oficina;
    String rua_oficina, bairro_oficina, num_casa_oficina, cidade_oficina, estado_oficina;

    public Oficina() {
    }

    public Oficina(int id_oficina, String rua_oficina, String bairro_oficina, String num_casa_oficina, String cidade_oficina, String estado_oficina) {
        this.id_oficina = id_oficina;
        this.rua_oficina = rua_oficina;
        this.bairro_oficina = bairro_oficina;
        this.num_casa_oficina = num_casa_oficina;
        this.cidade_oficina = cidade_oficina;
        this.estado_oficina = estado_oficina;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public String getRua_oficina() {
        return rua_oficina;
    }

    public void setRua_oficina(String rua_oficina) {
        this.rua_oficina = rua_oficina;
    }

    public String getBairro_oficina() {
        return bairro_oficina;
    }

    public void setBairro_oficina(String bairro_oficina) {
        this.bairro_oficina = bairro_oficina;
    }

    public String getNum_casa_oficina() {
        return num_casa_oficina;
    }

    public void setNum_casa_oficina(String num_casa_oficina) {
        this.num_casa_oficina = num_casa_oficina;
    }

    public String getCidade_oficina() {
        return cidade_oficina;
    }

    public void setCidade_oficina(String cidade_oficina) {
        this.cidade_oficina = cidade_oficina;
    }

    public String getEstado_oficina() {
        return estado_oficina;
    }

    public void setEstado_oficina(String estado_oficina) {
        this.estado_oficina = estado_oficina;
    }
    
}
