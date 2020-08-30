<%@ page errorPage="erro.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/validationLoginBean.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
                <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
        <jsp:include page="/head.jsp"/></head>
    <body>
        <jsp:include page="/nav.jsp" />
        <div class="container">
            <div class="row">
                <div class='container col-md-6 text-center'>
                    <div class='align-self-center m-5'>
                        <h2>Atendimentos em Aberto</h2>
                        <c:if test="${empty atendimentosEmAberto}">
                            <h2>Não há atendimentos</h2>
                        </c:if>
                    </div>
                </div>

                <div class="col-md-12 col-md-offset-2">
                    <div class='d-flex justify-content-center m-5'>
                        <c:if test="${!empty atendimentosEmAberto}">
                            <table class=' table  text-center'>
                                <tr>
                                    <th>Data/hora</th>
                                    <th>Produto</th>
                                    <th>Nome</th>
                                    <th>Detalhes Atendimento</th>
                                </tr>
                                <c:forEach items="${atendimentosEmAberto}" var="atendimento">
                                    <tr style="${atendimento.prioridade eq 1 ? 'background-color:#FFFFE0' : 'background-color :#FFFFE0  '}"  >
                                        <td><fmt:parseDate value="${atendimento.dataHoraAtendimento}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                                            <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }" />
                                        </td>
                                        <td><c:out value="${atendimento.produto.nomeProduto}" /></td>
                                        <td><c:out value="${atendimento.usuario.nomeUsuario}"/></td>
                                        <td>
                                            <a  class="mr-3" href="AtendimentoServlet?action=showFunc&id=${atendimento.idAtendimento}"><button><i class="fas fa-comment-dots fa-2x"></i></button></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
        <div>
            <jsp:include page="/footer.jsp" />
        </div>
    </body
</html>
