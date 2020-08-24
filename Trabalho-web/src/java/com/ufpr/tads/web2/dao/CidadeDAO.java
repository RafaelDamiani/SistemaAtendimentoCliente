package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.facade.EstadoFacade;


public class CidadeDAO {
    Connection conn = null;
    public List<Cidade> all() throws SQLException {

        List<Cidade> listaCidades = new ArrayList<Cidade>();
        try {

            conn = ConnectionFactory.getConnection();
            ResultSet rs = ConnectionFactory.getResultSet(conn, "SELECT * FROM tb_cidade");

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("id_cidade")); 
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                int idEstado = rs.getInt("id_estado"); 
                Estado estado = EstadoFacade.buscarEstadoCliente(idEstado);
                cidade.setEstado(estado);
                listaCidades.add(cidade);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null) {
                conn.close();
            }

        }
        return listaCidades;
    }
    
     public Cidade buscarPorId(int idCidade) throws SQLException{
         conn = null;
         Cidade cidade = new Cidade();
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
                Estado estado = EstadoFacade.buscarEstadoCliente(idEstado);
                cidade.setEstado(estado); 
            } else {
               cidade = null;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null) {
                conn.close();
            }
            return cidade;
        }
    }
     
    public List<Cidade> buscarCidadesPorEstado(int idEstado) throws SQLException {
         conn = null;
         List<Cidade> listaCidades = new ArrayList<Cidade>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_cidade WHERE id_estado = ?");
            statement.setInt(1, idEstado);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("id_cidade"));
                idEstado = rs.getInt("id_estado");
                Estado estado = EstadoFacade.buscarEstadoCliente(idEstado);
                cidade.setEstado(estado);
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                listaCidades.add(cidade);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null) {
                conn.close();
            }
            return listaCidades;
        
        }
    }

    public List<Cidade> getCidades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
