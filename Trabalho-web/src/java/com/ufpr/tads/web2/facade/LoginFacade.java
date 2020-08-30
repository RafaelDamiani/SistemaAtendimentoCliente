package com.ufpr.tads.web2.facade;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import com.ufpr.tads.web2.beans.UsuarioBean;

public class LoginFacade {
    private static final UsuarioDAO userDAO = new UsuarioDAO();
    
    public static UsuarioBean buscarUsuario(String login, String passwd) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException{
        String senha = UsuarioFacade.criptografarSenha(passwd);
        UsuarioBean user = userDAO.findByLogin(login, senha);
        return user;
    }
    
    public static UsuarioBean buscarUsuarioPorId(int idUser) throws SQLException{
        UsuarioBean user = userDAO.findById(idUser);
        return user;
    }
}