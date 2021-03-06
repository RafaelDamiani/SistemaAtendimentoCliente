package com.ufpr.tads.web2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
import com.ufpr.tads.web2.beans.CidadeBean;
import com.ufpr.tads.web2.beans.EstadoBean;
import com.ufpr.tads.web2.beans.UsuarioBean;
import com.ufpr.tads.web2.facade.UsuarioFacade;
import com.ufpr.tads.web2.facade.EstadoFacade;

@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
            RequestDispatcher rd;
            String strId, senha, pass;
            List<EstadoBean> estados;
            CidadeBean cidade;
            int id = 0, idCidade, numeroRua;

            List<UsuarioBean> listaUsuarios;
            String action = request.getParameter("action");
            if (action == null) {
                listaUsuarios = new ArrayList<>();
                listaUsuarios = UsuarioFacade.buscarTodosFuncionarios();
                request.setAttribute("listaFuncionarios", listaUsuarios);
                rd = getServletContext().getRequestDispatcher("/funcionarioListar.jsp");
                rd.forward(request, response);

            } else {
                List<UsuarioBean> listaUsers = new ArrayList<>();
                UsuarioBean user;
                switch (action) {
                    case "list":
                        listaUsuarios = new ArrayList<>();
                        listaUsuarios = UsuarioFacade.buscarTodosFuncionarios();
                        request.setAttribute("listaFuncionarios", listaUsuarios);
                        rd = getServletContext().getRequestDispatcher("/funcionarioListar.jsp");
                        rd.forward(request, response);
                    break;

                    case "show":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        user = UsuarioFacade.buscarPorId(id);
                        if (user != null) {
                            request.setAttribute("funcionario", user);
                            System.out.println(user.toString());
                            rd = getServletContext().getRequestDispatcher("/funcionarioVisualizar.jsp");
                            rd.forward(request, response);
                        }
                        break;

                    case "formUpdate":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        user = UsuarioFacade.buscarPorId(id);
                        if (user != null) {
                            request.setAttribute("funcionario", user);
                            estados = EstadoFacade.buscarTodos();
                            request.setAttribute("estados", estados);
                            System.out.println(getServletContext().toString());
                            rd = getServletContext().getRequestDispatcher("/funcionarioForm.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("funcionario", user);
                            rd = getServletContext().getRequestDispatcher("/funcionarioForm.jsp");
                            rd.forward(request, response);
                        }

                        break;

                    case "remove":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        UsuarioFacade.remover(id);
                        rd = getServletContext().getRequestDispatcher("/ClienteServlet?action=list");
                        rd.forward(request, response);
                        break;

                    case "update":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        user = new UsuarioBean();
                        user.setIdUsuario(id);
                        user.setNomeUsuario(request.getParameter("nome"));
                        user.setCpf(request.getParameter("cpf"));
                        user.setEmail(request.getParameter("email"));
                        user.setTelefone(request.getParameter("telefone"));
                        pass = request.getParameter("passwd");
                        senha = UsuarioFacade.criptografarSenha(pass);
                        user.setPassword(senha);
                        user.setNomeRua(request.getParameter("endereco"));
                        numeroRua = Integer.parseInt(request.getParameter("nrua"));
                        user.setNumeroRua(numeroRua);
                        user.setComplemento(request.getParameter("complemento"));
                        user.setBairro(request.getParameter("bairro"));
                        user.setCep(request.getParameter("cep"));
                        user.setTipoUsuario(request.getParameter("cargo"));
                        user.setCidade(request.getParameter("cidade"));

                        if (!user.getNomeUsuario().isEmpty() && !user.getCpf().isEmpty() && !user.getEmail().isEmpty()) {

                            if (UsuarioFacade.alterar(user, user.getTipoUsuario()) == 0) {
                               String str  = "Conta atualizada com sucesso para o funiConário " + user.getNomeUsuario();
                                request.setAttribute("msg", str);
                                rd = getServletContext().getRequestDispatcher("/main/portal.jsp");
                                rd.forward(request, response);

                            } else {
                                request.setAttribute("msg", "Erro ao atualizar usuário. ");
                                rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                rd.forward(request, response);
                            }
                        }
                        break;

                    case "formNew":
                        estados = EstadoFacade.buscarTodos();
                        request.setAttribute("estados", estados);
                        rd = getServletContext().getRequestDispatcher("/funcionarioForm.jsp");
                        rd.forward(request, response);
                        break;

                    case "new":
                        user = new UsuarioBean();
                        user.setNomeUsuario(request.getParameter("nome"));
                        user.setCpf(request.getParameter("cpf"));
                        user.setEmail(request.getParameter("email"));
                        user.setTelefone(request.getParameter("telefone"));
                        pass = request.getParameter("passwd");
                        senha = UsuarioFacade.criptografarSenha(pass);
                        user.setPassword(senha);
                        user.setNomeRua(request.getParameter("endereco"));
                        numeroRua = Integer.parseInt(request.getParameter("nrua"));
                        user.setNumeroRua(numeroRua);
                        user.setComplemento(request.getParameter("complemento"));
                        user.setBairro(request.getParameter("bairro"));
                        user.setCep(request.getParameter("cep"));
                        user.setTipoUsuario(request.getParameter("cargo"));
                        user.setCidade(request.getParameter("cidade"));

                        if (!user.getNomeUsuario().isEmpty() && !user.getCpf().isEmpty() && !user.getEmail().isEmpty()) {
                            UsuarioFacade.inserir(user, user.getTipoUsuario());
                            String str = "Conta criada com sucesso para o funcionário(a) " + user.getNomeUsuario();
                            request.setAttribute("msg", str);
                            rd = getServletContext().getRequestDispatcher("/portal.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("msg", "Acesso Inválido  para cadastrar usuário. ");
                            rd = getServletContext().getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);

                        }
                        break;
                }
        }
    }}

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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
