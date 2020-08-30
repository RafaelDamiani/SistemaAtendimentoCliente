<%@ page errorPage="erro.jsp" %>
<%@page import="java.util.List"%>
<%@include file="/validationLoginBean.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
        <jsp:include page="/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/nav.jsp"/>

        <div class='container col-md-6'>
            <div class='align-self-center m-5'>
                <h2 class='text-center col-12-md' style='color:#000'>Portal Servlet</h2>
            </div>
        </div>

        <div class='text-center'> 
            <h4>Clientes cadastrados no sistema</h4>
        </div>
        
        <c:choose>
                <c:when test="${empty listaClientes}" >
                    <div class="text-center">
                         <p class="m-5">O sistema não possui clientes cadastrados no momento. Se desejar cadastre um novo cliente agora mesmo!</p>  
                    </div>    
                </c:when>
            <c:otherwise>
                    <div class='d-flex justify-content-center m-5'>
                        <table class='table w-50 text-center'>    
                            <tr>
                                <th>id Cliente</th>
                                <th>Nome do cliente</th>
                                <th>CPF</th>
                                <th>Email</th>
                                <th>Ver/Editar/Excluir</th>
                            </tr>

                            <c:forEach items="${requestScope.listaClientes}" var="cliente">
                                <tr>
                                    <td><c:out value="${cliente.idCliente}"/></td>
                                    <td><c:out value="${cliente.nome}"/></td>
                                    <td><c:out value="${cliente.cpf}"/></td>
                                    <td><c:out value="${cliente.email}"/></td>

                                    <td> 
                                        <a class="button" href="ClienteServlet?action=show&id=${cliente.idCliente}" class="mr-3"><button><i class="far fa-eye fa-2x"></i></button></a>
                                        <a class="button" href="ClienteServlet?action=formUpdate&id=${cliente.idCliente}" class="mr-3"><button><i class="far fa-edit fa-2x"></button></i></a>
                                        <a href="#" data-toggle="modal" data-target="#myModal" ><button id="idCliente" value="${cliente.idCliente}"  ><i class="far fa-trash-alt fa-2x"></i></button></a> 
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
            </c:otherwise> 
        </c:choose>
        
        <div class="d-flex justify-content-center">
            <a href='ClienteServlet?action=formNew' class='btn btn-primary col-md-1 ml-2' style='float: right; '>Cadastrar User</a>
        </div>

        <jsp:include page="/modalRemove.jsp"/>
        
        <jsp:include page="/footer.jsp"/>
    </body>
</html>
<script>
$("#save").click(function () {
    var idCliente = $("#idCliente").val();
    var id = "action=remove" + "&id=" + idCliente;
    console.log(id);
    $('#myModal').modal('hide');
    $.ajax({
        type: "GET",
        url: "ClienteServlet",
        data: id,
        success: function (result) {
            location.reload();

        },
        error: function (error) {
            console.log("error" + error);
        }
    });
});</script>