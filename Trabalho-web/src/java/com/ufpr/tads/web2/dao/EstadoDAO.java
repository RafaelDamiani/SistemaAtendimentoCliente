
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    Connection conn = null;
    public List<Estado> all() throws SQLException {

        List<Estado> listaEstados = new ArrayList<Estado>();
        try {

            conn = ConnectionFactory.getConnection();
            ResultSet rs = ConnectionFactory.getResultSet(conn, "SELECT * FROM tb_estado");

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("id_estado")); 
                estado.setNomeEstado(rs.getString("nome_estado"));
                estado.setSigla(rs.getString("sigla"));
                listaEstados.add(estado);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null) {
                conn.close();
            }

        }
        return listaEstados;
    }
    
    public Estado buscarPorId(int idEstado) throws SQLException{
         conn = null;
         Estado estado = new Estado();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_estado WHERE id_estado = ?");
            statement.setInt(1, idEstado);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                estado.setIdEstado(rs.getInt("id_estado")); 
                estado.setSigla(rs.getString("sigla"));
                estado.setNomeEstado(rs.getString("nome_estado"));
            } else {
               estado = null;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null) {
                conn.close();
            }
            return estado;
        }
    }
}
