package com.ufpr.tads.web2.beans;

import java.io.Serializable;

public class CidadeBean implements Serializable{
    private int idCidade;
    private EstadoBean estado;
    private String nomeCidade;

    public CidadeBean() {
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public EstadoBean getEstado() {
        return estado;
    }

    public void setEstado(EstadoBean estado) {
        this.estado = estado;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}