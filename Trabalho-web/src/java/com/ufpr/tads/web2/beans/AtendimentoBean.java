package com.ufpr.tads.web2.beans;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AtendimentoBean {
    private int idAtendimento;
    private LocalDateTime dataHoraAtendimento;
    private String descricaoAtendimento;
    private String situacao;
    private String solucaoApresentada;
    private ProdutoBean produto;
    private TipoAtendimentoBean tipoAtendimento;
    private UsuarioBean usuario;
    private int prioridade;

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataConvertida() {
        return java.util.Date.from(this.getDataHoraAtendimento().atZone(ZoneId.systemDefault()).toInstant());
    }

    public AtendimentoBean() {
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public LocalDateTime getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(LocalDateTime dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;

    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSolucaoApresentada() {
        return solucaoApresentada;
    }

    public void setSolucaoApresentada(String solucaoApresentada) {
        this.solucaoApresentada = solucaoApresentada;
    }

    public ProdutoBean getProduto() {
        return produto;
    }

    public void setProduto(ProdutoBean produto) {
        this.produto = produto;
    }

    public TipoAtendimentoBean getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimentoBean tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
}
