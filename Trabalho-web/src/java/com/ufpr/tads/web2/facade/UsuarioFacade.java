package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.UsuarioBean;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class UsuarioFacade {
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
      
    public static String criptografarSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
       MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
       byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
         
       StringBuilder hexString = new StringBuilder();
       for (byte b : messageDigest) {
         hexString.append(String.format("%02X", 0xFF & b));
       }
       String senhahex = hexString.toString();
        
       System.out.println(senhahex);
       return senhahex;
    }
    
    public static UsuarioBean buscarPorId(int id) throws SQLException{
        UsuarioBean usuario = usuarioDAO.findById(id);
        return usuario;
    }

    public static UsuarioBean buscarPorId(int id, String cliente) throws SQLException {
       UsuarioBean usuario = usuarioDAO.findById(id, cliente);
       return usuario;
    }

    public static void inserir(UsuarioBean user, String tipoUsuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
       usuarioDAO.insert(user, tipoUsuario);
    }

    public static int alterar(UsuarioBean user, String tipoUsuario) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(usuarioDAO.alterar(user, tipoUsuario) == 0)
            return 0;
        else
            return 1;
    }
    
    public static void remover(int id) {
       usuarioDAO.remove(id);
    }

    public static List<UsuarioBean> buscarTodosFuncionarios() {
        List<UsuarioBean> funcionarios = usuarioDAO.allFuncionarios();
        return funcionarios;
    }

    public static List<UsuarioBean> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}