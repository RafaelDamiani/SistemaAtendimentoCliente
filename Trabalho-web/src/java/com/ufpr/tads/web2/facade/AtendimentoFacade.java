/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.ufpr.tads.web2.beans.AtendimentoBean;
import com.ufpr.tads.web2.dao.AtendimentoDAO;
/**
 *
 * @author Wenderson
 */
public class AtendimentoFacade {

    public static final AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

    public static List<AtendimentoBean> buscarTodosAtendimentos() throws SQLException {
        List<AtendimentoBean> listaAtendimentos = atendimentoDAO.all();
        return listaAtendimentos;
    }

    public static List<AtendimentoBean> buscarTodosAtendimentosAbertos() throws SQLException {
        List<AtendimentoBean> listaAtendimentos = atendimentoDAO.buscarAtendimentosAbertos();
        return listaAtendimentos;
    }

    public static AtendimentoBean buscarAtendimentoPorId(int id) throws SQLException {
        AtendimentoBean atendimento = atendimentoDAO.findById(id);
        return atendimento;
    }

    public static void inserirAtendimento(AtendimentoBean atendimento) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        atendimentoDAO.insert(atendimento);
    }

    public static void removerAtendimento(int idAtendimento) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        atendimentoDAO.delete(idAtendimento);
    }

    public static LocalDateTime converterStrToLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(data, formatter);
        return date;
    }

    public static List<AtendimentoBean> buscarTodosAtendimentosUser(int id) throws SQLException {
        List<AtendimentoBean> listaAtendimentos = atendimentoDAO.allByUser(id);
        return listaAtendimentos;
    }

    public static void responderAtendimento(int id, String solucao) throws SQLException {
        atendimentoDAO.responder(id, solucao);
    }
}
