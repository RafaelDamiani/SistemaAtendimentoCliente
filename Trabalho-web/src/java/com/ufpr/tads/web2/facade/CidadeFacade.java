/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.dao.CidadeDAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Alan 
 */

public class CidadeFacade {
    private static final CidadeDAO cidadeDAO = new CidadeDAO();
     
    public static List<Cidade> buscarCidadesPorEstado(int idEstado) throws SQLException {
       List<Cidade> listaCidades = cidadeDAO.buscarCidadesPorEstado(idEstado);
       return listaCidades;
    } 
    
    public static Cidade buscarCidadeCliente(int idCidade) throws SQLException {
      Cidade cidade = cidadeDAO.buscarPorId(idCidade);
      return cidade;
    }
}