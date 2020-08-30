package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.List;
import com.ufpr.tads.web2.beans.ProdutoBean;
import com.ufpr.tads.web2.dao.ProdutoDAO;

public class ProdutoFacade {
    public static final ProdutoDAO produtoDao = new ProdutoDAO();

    public static List<ProdutoBean> buscarTodos() throws SQLException {
        List<ProdutoBean> listaProdutos = produtoDao.all();
        return listaProdutos;
    }

    public static ProdutoBean buscarPorId(int idProduto) throws SQLException {
        ProdutoBean produto = produtoDao.findById(idProduto);
        return produto;
    }

    public static void remover(int id) {
        produtoDao.remove(id);
    }

    public static int alterar(ProdutoBean produto) {
        return produtoDao.alterar(produto);
    }

    public static void inserir(ProdutoBean produto) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        produtoDao.insert(produto);
    }
}
