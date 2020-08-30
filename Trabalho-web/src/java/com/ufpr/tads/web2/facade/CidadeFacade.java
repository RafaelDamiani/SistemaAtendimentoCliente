/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.CidadeBean;
import com.ufpr.tads.web2.dao.CidadeDAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Alan 
 */

public class CidadeFacade {
    private static final CidadeDAO cidadeDAO = new CidadeDAO();
     
    public static List<CidadeBean> buscarCidadesPorEstado(int idEstado) throws SQLException {
       List<CidadeBean> listaCidades = cidadeDAO.buscarCidadesPorEstado(idEstado);
       return listaCidades;
    } 
    
    public static CidadeBean buscarCidadeCliente(int idCidade) throws SQLException {
      CidadeBean cidade = cidadeDAO.buscarPorId(idCidade);
      return cidade;
    }
}