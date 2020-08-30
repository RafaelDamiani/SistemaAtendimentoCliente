package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.EstadoBean;
import com.ufpr.tads.web2.dao.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

public class EstadoFacade {
    private static final EstadoDAO estadoDAO = new EstadoDAO();
     
     public static List<EstadoBean> buscarTodos() throws SQLException{
         List<EstadoBean> listaEstados = estadoDAO.all();
         return listaEstados;
     }
    
    public static EstadoBean buscarEstadoCliente(int idEstado) throws SQLException {
      EstadoBean estado = estadoDAO.buscarPorId(idEstado);
      return estado;
    }
}