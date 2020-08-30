/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.List;
import com.ufpr.tads.web2.beans.CategoriaBean;
import com.ufpr.tads.web2.dao.CategoriaDAO;
        ;
/**
 *
 * @author Wenderson
 */
public class CategoriaFacade {

    private static final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public static List<CategoriaBean> buscarTodos() throws SQLException {
        List<CategoriaBean> categorias = categoriaDAO.all();
        return categorias;
    }

    public static CategoriaBean buscarPorId(int id) throws SQLException {
        CategoriaBean categoria = categoriaDAO.findById(id);
        return categoria;
    }

    public static void remover(int id) {
        categoriaDAO.remove(id);
    }

    public static int alterar(CategoriaBean categoria) {
        return categoriaDAO.alterar(categoria);
    }

    public static void inserir(CategoriaBean categoria) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        categoriaDAO.insert(categoria);
    }
}
