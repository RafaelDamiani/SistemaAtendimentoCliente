package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.beans.CategoriaBean;

public class CategoriaDAO {

    Connection conn = null;

    public List<CategoriaBean> all() throws SQLException {
        List<CategoriaBean> listaCategorias = null;
        try {
            listaCategorias = new ArrayList<>();
            conn = ConnectionFactory.getConnection();
            ResultSet rs = ConnectionFactory.getResultSet(conn, "SELECT * FROM tb_categoria ORDER BY id_categoria");
            while (rs.next()) {
                CategoriaBean categoria = new CategoriaBean();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                listaCategorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
        }
        return listaCategorias;
    }

    public CategoriaBean findById(int id) throws SQLException {
        CategoriaBean categoria = new CategoriaBean();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_categoria WHERE id_categoria = ? ");
            statement.setInt(1, id);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
            } else
                categoria = null;
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null)
                conn.close();

            return categoria;
        }

    }

    public void insert(CategoriaBean categoria) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn, "INSERT INTO tb_categoria values (null,?)");
            statement.setString(1, categoria.getNomeCategoria());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    public int alterar(CategoriaBean categoria) {
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "UPDATE tb_categoria SET nome_categoria=?  WHERE id_categoria=?");
            statement.setString(1, categoria.getNomeCategoria());
            statement.setInt(2, categoria.getIdCategoria());
            statement.executeUpdate();
            System.out.println("Categoria de id: " + categoria.getIdCategoria() + "alterado com sucesso");
            return 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
            //throw new RuntimeException("Erro ao atualizar cliente." + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Erro ao fechar conexão.");
                }
            }

        }
    }

    public void remove(int id) {
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "DELETE FROM tb_categoria WHERE id_categoria=?");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar categoria.");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Erro ao fechar conexão.");
                }
            }
        }
    }
}

