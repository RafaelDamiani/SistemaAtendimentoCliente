
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


/**
 *
 * @author Wenderson
 */

public class Cidade implements Serializable{
    private int idCidade;
    private Estado estado;
    private String nomeCidade;

    public Cidade() {
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

  
}