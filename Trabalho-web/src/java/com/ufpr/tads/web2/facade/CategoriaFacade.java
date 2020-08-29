/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.List;
import com.ufpr.tads.web2.beans.Categoria;
import com.ufpr.tads.web2.dao.CategoriaDAO;
        ;
/**
 *
 * @author Wenderson
 */
public class CategoriaFacade {

    private static final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public static List<Categoria> buscarTodos() throws SQLException {
        List<Categoria> categorias = categoriaDAO.all();
        return categorias;
    }

    public static Categoria buscarPorId(int id) throws SQLException {
        Categoria categoria = categoriaDAO.findById(id);
        return categoria;
    }

    public static void remover(int id) {
        categoriaDAO.remove(id);
    }

    public static int alterar(Categoria categoria) {
        return categoriaDAO.alterar(categoria);
    }

    public static void inserir(Categoria categoria) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        categoriaDAO.insert(categoria);
    }
}
