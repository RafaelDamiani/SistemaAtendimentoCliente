package com.ufpr.tads.web2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ufpr.tads.web2.beans.CategoriaBean;
import com.ufpr.tads.web2.beans.ProdutoBean;
import com.ufpr.tads.web2.facade.ProdutoFacade;
import com.ufpr.tads.web2.facade.CategoriaFacade;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            RequestDispatcher rd;
            String strId, strMessage;
            Double pesoProduto = 0.0;
            int id = 0;
            List<ProdutoBean> listaProdutos = new ArrayList<>();
            List<CategoriaBean> listaCategorias = new ArrayList<>();
            String action = request.getParameter("action");
            ProdutoBean produto = null;
            CategoriaBean categoria = null;
            switch (action) {
                case "list":
                    listaProdutos = new ArrayList<>();
                    listaProdutos = ProdutoFacade.buscarTodos();
                    request.setAttribute("listaProdutos", listaProdutos);
                    rd = getServletContext().getRequestDispatcher("/produto.jsp");
                    rd.forward(request, response);

                    break;

                case "formUpdate":

                    strId = request.getParameter("id");
                    id = Integer.parseInt(strId);
                    produto = ProdutoFacade.buscarPorId(id);
                    request.setAttribute("produto", produto);
                    request.setAttribute("showDiv", "update");
                    listaProdutos = ProdutoFacade.buscarTodos();
                    request.setAttribute("listaProdutos", listaProdutos);
                    listaCategorias = CategoriaFacade.buscarTodos();
                    request.setAttribute("listaCategorias", listaCategorias);
                    rd = getServletContext().getRequestDispatcher("/produto.jsp");
                    rd.forward(request, response);
                    break;

                case "remove":
                    strId = request.getParameter("id");
                    id = Integer.parseInt(strId);
                    ProdutoFacade.remover(id);
                    strMessage = "Produto com id " + id + " removida com sucesso!";
                    request.setAttribute("msg", strMessage);
                    listaProdutos = ProdutoFacade.buscarTodos();
                    request.setAttribute("listaProdutos", listaProdutos);
                    rd = getServletContext().getRequestDispatcher("/produto.jsp");
                    rd.forward(request, response);
                    break;

                case "update":
                    strId = request.getParameter("id");
                    id = Integer.parseInt(strId);
                    produto = new ProdutoBean();
                    produto.setIdProduto(id);
                    produto.setNomeProduto(request.getParameter("nome_produto"));
                    produto.setDescricaoProduto(request.getParameter("descricao_produto"));
                    pesoProduto = Double.parseDouble(request.getParameter("peso_produto"));
                    produto.setPesoProduto(pesoProduto);
                    id = Integer.parseInt(request.getParameter("categoria_produto"));
                    categoria = CategoriaFacade.buscarPorId(id);
                    produto.setCategoria(categoria);
                    if (!produto.getNomeProduto().equals(null) && produto.getCategoria() != null) {

                        if (ProdutoFacade.alterar(produto) == 0) {
                            strMessage = "Produto com id " + produto.getIdProduto() + " atualizado com sucesso!";
                            request.setAttribute("msg", strMessage);
                            listaProdutos = ProdutoFacade.buscarTodos();
                            request.setAttribute("listaProdutos", listaProdutos);
                            rd = getServletContext().getRequestDispatcher("/produto.jsp");
                            rd.forward(request, response);

                        } else {
                            request.setAttribute("msg", "Erro ao atualizar usuário. ");
                            rd = getServletContext().getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        }
                    }
                    break;

                case "formNew":
                    request.setAttribute("showDiv", "new");
                    listaProdutos = ProdutoFacade.buscarTodos();
                    request.setAttribute("listaProdutos", listaProdutos);
                    listaCategorias = CategoriaFacade.buscarTodos();
                    request.setAttribute("listaCategorias", listaCategorias);
                    rd = getServletContext().getRequestDispatcher("/produto.jsp");
                    rd.forward(request, response);
                    break;

                case "new":
                    produto = new ProdutoBean();
                    produto.setIdProduto(id);
                    produto.setNomeProduto(request.getParameter("nome_produto"));
                    produto.setDescricaoProduto(request.getParameter("descricao_produto"));
                    pesoProduto = Double.parseDouble(request.getParameter("peso_produto"));
                    produto.setPesoProduto(pesoProduto);
                    id = Integer.parseInt(request.getParameter("categoria_produto"));
                    categoria = CategoriaFacade.buscarPorId(id);
                    produto.setCategoria(categoria);
                    if (!produto.getNomeProduto().equals(null) && produto.getCategoria() != null) {
                        ProdutoFacade.inserir(produto);
                        strMessage = "Produto " + produto.getNomeProduto() + " cadastrado com sucesso";
                        request.setAttribute("msg", strMessage);
                        listaProdutos = ProdutoFacade.buscarTodos();
                        request.setAttribute("listaProdutos", listaProdutos);
                        rd = getServletContext().getRequestDispatcher("/produto.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("msg", "Acesso Inválido  para cadastrar usuário. ");
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);

                    }
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
