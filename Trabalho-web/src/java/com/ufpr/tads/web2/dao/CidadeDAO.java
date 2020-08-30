package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.CidadeBean;
import com.ufpr.tads.web2.beans.EstadoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.facade.EstadoFacade;

public class CidadeDAO {
    Connection conn = null;
    public List<CidadeBean> all() throws SQLException {

        List<CidadeBean> listaCidades = new ArrayList<CidadeBean>();
        try {
            conn = ConnectionFactory.getConnection();
            ResultSet rs = ConnectionFactory.getResultSet(conn, "SELECT * FROM tb_cidade");

            while (rs.next()) {
                CidadeBean cidade = new CidadeBean();
                cidade.setIdCidade(rs.getInt("id_cidade")); 
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                int idEstado = rs.getInt("id_estado"); 
                EstadoBean estado = EstadoFacade.buscarEstadoCliente(idEstado);
                cidade.setEstado(estado);
                listaCidades.add(cidade);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return listaCidades;
    }
    
     public CidadeBean buscarPorId(int idCidade) throws SQLException{
         conn = null;
         CidadeBean cidade = new CidadeBean();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_cidade WHERE id_cidade = ?");
            statement.setInt(1, idCidade);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                cidade.setIdCidade(rs.getInt("id_cidade")); 
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                int idEstado = rs.getInt("id_estado"); 
                EstadoBean estado = EstadoFacade.buscarEstadoCliente(idEstado);
                cidade.setEstado(estado); 
            } else
               cidade = null;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();

            return cidade;
        }
    }
     
    public List<CidadeBean> buscarCidadesPorEstado(int idEstado) throws SQLException {
         System.out.println(idEstado);
       conn = null; 
         List<CidadeBean> listaCidades = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_cidade WHERE id_estado = ?");
            statement.setInt(1, idEstado);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CidadeBean cidade = new CidadeBean();
                cidade.setIdCidade(rs.getInt("id_cidade"));
                idEstado = rs.getInt("id_estado");
                EstadoBean estado = EstadoFacade.buscarEstadoCliente(idEstado);
                cidade.setEstado(estado);
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                listaCidades.add(cidade);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();

            return listaCidades;
        }
    }
}
