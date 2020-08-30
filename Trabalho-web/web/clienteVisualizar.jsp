<%@ page errorPage="erro.jsp" %>
<%@include file="/validationLoginBean.jsp"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
        <jsp:include page="/nav.jsp"/>
           
        <div class='container col-md-6'>
            <div class='align-self-center m-5'>
               <h4>Dados do cliente</h4>
            </div>
        </div>
        
        <div class='container d-flex justify-content-center'>
            <table class="table w-50 mb-3">
                <tr>
                    <td><c:out value="Id :"/></td> 
                    <td><c:out value="${cliente.idCliente}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Nome :"/></td> 
                    <td><c:out value="${cliente.nome}"/></td> 
                </tr> 
                 <tr>
                    <td><c:out value="CPF :"/></td> 
                    <td><c:out value="${cliente.cpf}"></c:out></td> 
                </tr>
                 <tr>
                    <td><c:out value="Email :"/></td> 
                    <td><c:out value="${cliente.email}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Data de Nascimento do Cliente :"/></td> 
                    <td><fmt:formatDate value="${cliente.dataConvertida}" pattern="dd/MM/yyyy"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Rua do Cliente :"/></td> 
                    <td><c:out value="${cliente.rua}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="NÃºmero :"/></td> 
                    <td><c:out value="${cliente.numeroRua}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="CEP :"/></td> 
                    <td><c:out value="${cliente.cep}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Cidade :"/></td> 
                    <td><c:out value="${cliente.cidade.nomeCidade}"/></td> 
                </tr>
                 <tr>
                    <td><c:out value="UF :"/></td> 
                    <td><c:out value="${cliente.cidade.estado.sigla}"/></td> 
                </tr> 
            </table>
        </div>
                    
         <div class="d-flex justify-content-center">
             <a href='ClienteServlet?action=list' class='btn btn-primary col-md-1 ml-2' style='float: right; '>Voltar</a>
         </div>
            <jsp:include page="/footer.jsp"/>
    </body>
</html>