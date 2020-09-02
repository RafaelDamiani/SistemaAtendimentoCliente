<%@ page errorPage="erro.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="navbar navbar-light" style="background-color: #343a40">
    <a class="navbar-brand" style="color:#FFFFFF" href="index.jsp">Cabeleleila Leila</a>
        <c:choose>
            <c:when test="${loginBean.tipoUsuario == 'c'}">
                <a class="nav-item nav-link active" style="color: #fff" href="ClienteServlet?action=formUpdate&id=${loginBean.id}"> Alterar Dados <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link active" style="color: #fff" href="AtendimentoServlet?action=create">Criar atendimento</a>
                <a class="nav-item nav-link active" style="color: #fff" href="AtendimentoServlet?action=list">Meus atendimentos</a>
            </c:when>

            <c:when test="${loginBean.tipoUsuario == 'f'}">
                <a class="nav-item nav-link active" style="color: #fff" href="AtendimentoServlet?action=listarAbertos">Listar todos os atendimentos em aberto</a>
                <a class="nav-item nav-link active" style="color: #fff" href="AtendimentoServlet?action=listarTodosAtendimentos">Listar todos os atendimentos</a>
                <a class="nav-item nav-link active" style="color: #fff" href="ProdutoServlet?action=formNew">Cadastrar Produtos</a>
                <a class="nav-item nav-link active" style="color: #fff" href="CategoriaServlet?action=formNew"">Cadastrar Categorias</a>
            </c:when>

            <c:when test="${loginBean.tipoUsuario == 'g'}">
                <a class="nav-item nav-link active" style="color: #fff" href="FuncionarioServlet?action=formNew">Cadastrar Funcionário/Gerente</a>
                <a class="nav-item nav-link active" style="color: #fff" href="FuncionarioServlet?action=list">Listar Funcionários</a>
                <a class="nav-item nav-link active" style="color: #fff" href="AtendimentoServlet?action=listarAbertos">Listar todos os atendimentos em aberto</a>
                <a class="nav-item nav-link active" style="color: #fff" href="AtendimentoServlet?action=listarTodosAtendimentos">Listar todos os atendimentos</a>
                <a class="nav-item nav-link active" style="color: #fff"href="relatorio.jsp" aria-haspopup="true" aria-expanded="false">Gerar Relatórios</a>
            </c:when>
        </c:choose>
    <div class="d-flex flex-row-reverse text-white">
        <c:if test="${!empty loginBean}">
            <a href='LogoutServlet' class='btn btn-primary btn-sm  mt-3 mr-3 h-50'>SAIR</a>
            <span class="m  r-3 m-3"> <c:out value="${loginBean.nomeUsuario}"/> </span>
            <i class="far fa-user-circle fa-2x mt-3"></i>
        </c:if>
        <c:if test="${empty loginBean}">
            <a class="nav-item nav-link active text-white" href="http://localhost:8080/Trabalho-web/login.jsp">Sign in <span class="sr-only"></span></a>
            <a class="nav-item nav-link active text-white" href="http://localhost:8080/Trabalho-web/ClienteServlet?action=formNew">Cadastrar<span class="sr-only"></span></a>
        </c:if>
    </div>
</nav>
