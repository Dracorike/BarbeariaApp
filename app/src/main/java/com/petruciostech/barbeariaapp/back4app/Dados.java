package com.petruciostech.barbeariaapp.back4app;
/*
* Essa classe foi criada para conter os dados que vem do banco de dados do back4app.
* A escolha feita na Activity "MainActivity" pões dentro dessa classe as informações
* que serão passadas para a activity "PayHairCut"
*/
import java.io.Serializable;

public class Dados implements Serializable {
    private String nomeDoCorte;//O nome do corte
    private String tipoDoCorte;//Aqui é o tipo de corte que pode ser "Cabelo" ou "Barba"
    //O tipo do corte é declarado no banco de dados na classe "Cortes"
    private double preco;//Quanto o corte custa

    //Getters and Setters faz parte do básico de uma criação de classe
    public String getTipoDoCorte() {
        return tipoDoCorte;
    }
    public void setTipoDoCorte(String tipoDoCorte) {
        this.tipoDoCorte = tipoDoCorte;
    }

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
