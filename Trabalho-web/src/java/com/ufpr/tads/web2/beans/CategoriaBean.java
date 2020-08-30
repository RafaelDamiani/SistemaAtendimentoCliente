package com.ufpr.tads.web2.beans;

import java.io.Serializable;

public class CategoriaBean implements Serializable{
    private int idCategoria;
    private String nomeCategoria;
    
    public CategoriaBean(){
        
    }
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}

