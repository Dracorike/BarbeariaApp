package com.petruciostech.barbeariaapp.back4app;

import java.io.Serializable;

public class Dados implements Serializable {
    private String nomeDoCorte;
    private double preco;

    public String getNomeDoCorte() {
        return nomeDoCorte;
    }
    public void setNomeDoCorte(String nomeDoCorte) {
        this.nomeDoCorte = nomeDoCorte;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
