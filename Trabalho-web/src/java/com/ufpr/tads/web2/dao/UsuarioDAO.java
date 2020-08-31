package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ufpr.tads.web2.beans.CidadeBean;
import com.ufpr.tads.web2.facade.CidadeFacade;
import com.ufpr.tads.web2.facade.UsuarioFacade;

public class UsuarioDAO {
    List<UsuarioBean> listaUsuarios = new ArrayList<UsuarioBean>();
    Connection conn = null;

    public List<UsuarioBean> all() throws SQLException {
        try {
            conn = ConnectionFactory.getConnection();
            ResultSet rs = ConnectionFactory.getResultSet(conn, "SELECT * FROM tb_usuario");
            while (rs.next()) {
                UsuarioBean user = new UsuarioBean();
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setEmail(rs.getString("email"));
                user.setNomeUsuario(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setTelefone(rs.getString("telefone"));
                user.setCep(rs.getString("cep"));
                user.setNomeRua(rs.getString("nome_rua"));
                user.setNumeroRua(rs.getInt("numero_rua"));
                user.setComplemento(rs.getString("complemento"));
                user.setBairro(rs.getString("bairro"));
                user.setCidade(rs.getString("cidade"));

                listaUsuarios.add(user);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return listaUsuarios;
    }

    public UsuarioBean findByLogin(String login, String passwd) throws SQLException {
        UsuarioBean user = new UsuarioBean();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_usuario WHERE email=? AND senha=?");
            statement.setString(1, login);
            statement.setString(2, passwd);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new UsuarioBean();
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setNomeUsuario(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("senha"));
                user.setTipoUsuario(rs.getString("tipo_usuario"));
            } else
                user = null;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
            
            return user;
        }
    }

    public UsuarioBean findById(int idUser) throws SQLException {
        UsuarioBean user = new UsuarioBean();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_usuario WHERE id_usuario = ? ");
            statement.setInt(1, idUser);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setNomeUsuario(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setEmail(rs.getString("email"));
                user.setTelefone(rs.getString("telefone"));
                user.setNomeRua(rs.getString("nome_rua"));
                user.setNumeroRua(rs.getInt("numero_rua"));
                user.setComplemento(rs.getString("complemento"));
                user.setBairro(rs.getString("bairro"));
                user.setCep(rs.getString("cep"));
                user.setTipoUsuario(rs.getString("tipo_usuario"));
                user.setCidade(rs.getString("cidade"));
            } else
                user = null;
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null)
                conn.close();

            return user;
        }
    }

    public void insert(UsuarioBean user, String tipoUsuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "INSERT INTO tb_usuario (nome, cpf ,email , senha, telefone, nome_rua, numero_rua, complemento, bairro, cep, tipo_usuario, cidade)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?) ");
            statement.setString(1, user.getNomeUsuario());
            statement.setString(2, user.getCpf().replaceAll("\\D", ""));
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getTelefone().replaceAll("\\D", ""));
            statement.setString(6, user.getNomeRua());
            statement.setInt(7, user.getNumeroRua());
            statement.setString(8, user.getComplemento());
            statement.setString(9, user.getBairro());
            statement.setString(10, user.getCep());
            statement.setString(11, tipoUsuario);
            statement.setString(12, user.getCidade());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    public UsuarioBean findById(int id, String tipoUsuario) throws SQLException {
        conn = null;
        UsuarioBean user = new UsuarioBean();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn,
                    "SELECT * FROM tb_usuario WHERE id_usuario = ? AND tipo_usuario = ?");
            statement.setInt(1, id);
            statement.setString(2, tipoUsuario);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setNomeUsuario(rs.getString("nome"));
                user.setTelefone(rs.getString("telefone"));
                user.setNomeRua(rs.getString("nome_rua"));
                user.setNumeroRua(rs.getInt("numero_rua"));
                user.setComplemento(rs.getString("complemento"));
                user.setBairro(rs.getString("bairro"));
                user.setCep(rs.getString("cep"));
                user.setTipoUsuario(rs.getString("tipo_usuario"));
                user.setCidade(rs.getString("cidade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();

            return user;
        }
    }

    public int alterar(UsuarioBean user, String tipoUsuario) {
        try {
            conn = ConnectionFactory.getConnection();
            
            String query = "UPDATE tb_usuario SET nome=?, telefone=?, nome_rua=?, numero_rua=?, complemento=?, bairro=?, cep=?, tipo_usuario=?,cidade=? WHERE id_usuario=?";
            String pwd = "";
            if (user.getPassword() != null) {
                pwd = UsuarioFacade.criptografarSenha(user.getPassword());
                query = "UPDATE tb_usuario SET nome=?, telefone=?, nome_rua=?, numero_rua=?, complemento=?, bairro=?, cep=?, tipo_usuario=?,cidade=?, senha=? WHERE id_usuario=?";
            }
            
            PreparedStatement statement = ConnectionFactory.getPreparedStatement(conn, query);
            
            statement.setString(1, user.getNomeUsuario());
            statement.setString(2, user.getTelefone().replaceAll("\\D", ""));
            statement.setString(3, user.getNomeRua());
            statement.setInt(4,user.getNumeroRua());
            statement.setString(5,user.getComplemento());
            statement.setString(6,user.getBairro());
            statement.setString(7,user.getCep().replaceAll("\\D", ""));
            statement.setString(8,tipoUsuario);
            statement.setString(9, user.getCidade());
            
            if (user.getPassword() != null) {
                statement.setString(10, pwd);
                statement.setInt(11, user.getIdUsuario());
            }
            else
                statement.setInt(10, user.getIdUsuario());
          
            statement.executeUpdate();
            System.out.println(tipoUsuario + " " + user.getNomeUsuario() + "alterado com sucesso");
            
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
                    "DELETE FROM tb_usuario WHERE id_usuario=?");
            statement.setInt(1, id);
            statement.execute();
        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar usuário.");
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                   throw new RuntimeException("Erro ao fechar conexão.");
                }
            }
        }
    }
  
    public List<UsuarioBean> allFuncionarios() {
        try {
            listaUsuarios = new ArrayList<UsuarioBean>();
            conn = ConnectionFactory.getConnection();
            ResultSet rs = ConnectionFactory.getResultSet(conn, "SELECT * FROM tb_usuario WHERE tipo_usuario='Funcionario' OR tipo_usuario='Gerente'");
            while (rs.next()) {
                UsuarioBean user = new UsuarioBean();
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setNomeUsuario(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setEmail(rs.getString("email"));
                user.setTelefone(rs.getString("telefone"));
                user.setNomeRua(rs.getString("nome_rua"));
                user.setNumeroRua(rs.getInt("numero_rua"));
                user.setComplemento(rs.getString("complemento"));
                user.setBairro(rs.getString("bairro"));
                user.setCep(rs.getString("cep"));
                user.setTipoUsuario(rs.getString("tipo_usuario"));
                user.setCidade(rs.getString("cidade"));

                listaUsuarios.add(user);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaUsuarios;
    }
}
