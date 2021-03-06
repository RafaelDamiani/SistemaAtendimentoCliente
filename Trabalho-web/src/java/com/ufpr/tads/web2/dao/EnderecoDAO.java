package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.CidadeBean;
import com.ufpr.tads.web2.beans.EnderecoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {
    private Connection conn;

    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        this.conn = ConnectionFactory.getConnection();
    }
    
    public void insertEndereço(EnderecoBean endereço) throws SQLException {
        String sql = "INSERT INTO tb_endereco "
                + "(rua_endereco, numero_endereco, cep_endereco, id_cidade, referencia_endereco, id_referencia) "
                + "VALUES ((?), (?), (?), (?), (?), (?));";
        PreparedStatement st = conn.prepareStatement(sql);
        
        st.setString(1, endereço.getRua());
        st.setInt(2, endereço.getNumero());
        st.setString(3, endereço.getCep());
        st.setInt(4, endereço.getCidade().getIdCidade());
        st.setString(5, endereço.getReferencia());
        st.setInt(6, endereço.getIdReferencia());
        
        st.executeUpdate();
    }
    
    public void updateEndereçoById(EnderecoBean endereço) throws SQLException {
        String sql = "UPDATE tb_endereco "
                + "SET rua_endereco = (?), numero_endereco = (?), cep_endereco = (?), id_cidade = (?), referencia_endereco = (?), id_referencia = (?) "
                + "WHERE id_endereco = (?);";
        PreparedStatement st = conn.prepareCall(sql);
        
        st.setString(1, endereço.getRua());
        st.setInt(2, endereço.getNumero());
        st.setString(3, endereço.getCep());
        st.setInt(4, endereço.getCidade().getIdCidade());
        st.setString(5, endereço.getReferencia());
        st.setInt(6, endereço.getIdReferencia());
        st.setInt(7, endereço.getId());
        
        st.executeUpdate();
    }
    
    public void updateEndereçoByIdRefencia(EnderecoBean endereço) throws SQLException {
        String sql = "UPDATE tb_endereco "
                + "SET rua_endereco = (?), numero_endereco = (?), cep_endereco = (?), id_cidade = (?) "
                + "WHERE id_referencia = (?) AND referencia_endereco = (?);";
        PreparedStatement st = conn.prepareCall(sql);
        
        st.setString(1, endereço.getRua());
        st.setInt(2, endereço.getNumero());
        st.setString(3, endereço.getCep());
        st.setInt(4, endereço.getCidade().getIdCidade());
        st.setInt(5, endereço.getIdReferencia());
        st.setString(6, endereço.getReferencia());
        
        st.executeUpdate();
    }
    
    public void deleteEndereçoById(int id) throws SQLException {
        String sql = "DELETE FROM tb_endereco "
                + "WHERE id_endereco = (?);";
        PreparedStatement st = conn.prepareStatement(sql);
        
        st.setInt(1, id);
        
        st.executeUpdate();
    }
    
    public EnderecoBean selectEndereçoById(int id) throws SQLException {
        String sql = "SELECT * "
                + "FROM tb_endereco "
                + "WHERE id_endereco = (?);";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        EnderecoBean endereço = new EnderecoBean();
        
        while (rs.next()) {
            endereço.setId(rs.getInt("id_endereco"));
            endereço.setRua(rs.getString("rua_endereco"));
            endereço.setNumero(rs.getInt("numero_endereco"));
            endereço.setCep(rs.getString("cep_endereco"));
            CidadeBean cidade = new CidadeBean();
            cidade.setIdCidade(rs.getInt("id_cidade"));
            endereço.setCidade(cidade);
            endereço.setReferencia(rs.getString("referencia_endereco"));
            endereço.setIdReferencia(rs.getInt("id_referencia"));
        }
        return endereço;
    }
    
    public EnderecoBean selectEndereçoByIdReferenciaAndReferencia(int id, String referencia) throws SQLException {
        String sql = "SELECT * "
                + "FROM tb_endereco "
                + "WHERE id_referencia = (?) AND referencia_endereco = (?);";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, id);
        st.setString(2, referencia);
        ResultSet rs = st.executeQuery();
        EnderecoBean endereço = new EnderecoBean();
        
        while (rs.next()) {
            endereço.setId(rs.getInt("id_endereco"));
            endereço.setRua(rs.getString("rua_endereco"));
            endereço.setNumero(rs.getInt("numero_endereco"));
            endereço.setCep(rs.getString("cep_endereco"));
            CidadeBean cidade = new CidadeBean();
            cidade.setIdCidade(rs.getInt("id_cidade"));
            endereço.setCidade(cidade);
            endereço.setReferencia(rs.getString("referencia_endereco"));
            endereço.setIdReferencia(rs.getInt("id_referencia"));
        }
        return endereço;
    }
}
