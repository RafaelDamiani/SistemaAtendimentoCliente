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
import com.ufpr.tads.web2.beans.EstadoBean;
import com.ufpr.tads.web2.beans.CidadeBean;
import com.ufpr.tads.web2.beans.UsuarioBean;
import com.ufpr.tads.web2.facade.UsuarioFacade;
import com.ufpr.tads.web2.facade.EstadoFacade;
import com.ufpr.tads.web2.facade.CidadeFacade;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {
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
                listaUsuarios = new ArrayList<UsuarioBean>();
                listaUsuarios = UsuarioFacade.buscarTodos();
                request.setAttribute("listaClientes", listaUsuarios);
                rd = getServletContext().getRequestDispatcher("/clienteListar.jsp");
                rd.forward(request, response);

            } else {
                List<UsuarioBean> listaUsers = new ArrayList<UsuarioBean>();
                UsuarioBean user;
                switch (action) {
                    case "list":
                        listaUsuarios = new ArrayList<UsuarioBean>();
                        listaUsuarios = UsuarioFacade.buscarTodos();
                        request.setAttribute("listaClientes", listaUsuarios);
                        rd = getServletContext().getRequestDispatcher("/clienteListar.jsp");
                        rd.forward(request, response);

                        break;

                    case "show":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        user = UsuarioFacade.buscarPorId(id, "c");
                        if (user != null) {
                            request.setAttribute("user", user);
                            rd = getServletContext().getRequestDispatcher("/clienteVisualizar.jsp");
                            rd.forward(request, response);
                        }
                        break;

                    case "formUpdate":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        user = UsuarioFacade.buscarPorId(id, "c");
                        if (user != null) {
                            request.setAttribute("cliente", user);
                            estados = EstadoFacade.buscarTodos();
                            request.setAttribute("estados", estados);
                            System.out.println(getServletContext().toString());
                            rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("cliente", user);
                            rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                            rd.forward(request, response);
                        }

                        break;

                    case "remove":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        //UsuarioFacade.remover(id);
                        rd = getServletContext().getRequestDispatcher("/ClienteServlet?action=list");
                        rd.forward(request, response);
                        break;

                    case "update":
                        strId = request.getParameter("id");
                        id = Integer.parseInt(strId);
                        user = new UsuarioBean();
                        user.setIdUsuario(id);
                        user.setNomeUsuario(request.getParameter("nome"));
                        user.setEmail(request.getParameter("email"));
                        user.setTelefone(request.getParameter("telefone"));
                        pass = request.getParameter("passwd");
                        if (!pass.isEmpty()) {
                            senha = UsuarioFacade.criptografarSenha(pass);
                            user.setPassword(senha);
                        }
                        user.setNomeRua(request.getParameter("endereco"));
                        numeroRua = Integer.parseInt(request.getParameter("nrua"));
                        user.setNumeroRua(numeroRua);
                        user.setComplemento(request.getParameter("complemento"));
                        user.setBairro(request.getParameter("bairro"));
                        user.setCep(request.getParameter("cep"));
                        user.setCidade(request.getParameter("cidade"));
                        
                        if (!user.getNomeUsuario().isEmpty()) {

                            if (UsuarioFacade.alterar(user, "c") == 0) {
                                System.out.println(user.getNomeUsuario());
                                System.out.println(user.getEmail());
                                request.setAttribute("msg", user.getNomeUsuario() + ", sua conta foi atualizada com sucesso");
                                rd = getServletContext().getRequestDispatcher("/portal.jsp");
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
                        rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
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
                        user.setCidade(request.getParameter("cidade"));

                        if (!user.getNomeUsuario().equals(null) && !user.getCpf().equals(null) && !user.getEmail().equals(null)) {
                            UsuarioFacade.inserir(user, "Cliente");
                            String str = user.getNomeUsuario() + ", sua conta foi criada com sucesso";
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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