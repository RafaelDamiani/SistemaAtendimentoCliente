package com.ufpr.tads.web2.beans;

import java.io.Serializable;

public class TipoAtendimentoBean implements Serializable{
    private int idTipoAtendimento;
    private String nomeTipoAtendimento;

    public TipoAtendimentoBean() {
    }

    public int getIdTipoAtendimento() {
        return idTipoAtendimento;
    }

    public void setIdTipoAtendimento(int idTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
    }

    public String getNomeTipoAtendimento() {
        return nomeTipoAtendimento;
    }

    public void setNomeTipoAtendimento(String nomeTipoAtendimento) {
        this.nomeTipoAtendimento = nomeTipoAtendimento;
    }
}
