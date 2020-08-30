<%@ page errorPage="erro.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/validationLoginBean.jsp"%>
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
        <jsp:include page="/head.jsp"/></head>
    <body>
    
        <jsp:include page="/nav.jsp"/>
           
        <div class='container col-md-6'>
            <div class='align-self-center m-5'>
               <h2 class='text-center col-12-md' style='color:#000'>Portal Servlet</h2>
            </div>
        </div>
        
        <div class='text-center m-5'> 
            <h4>Dados do funcionario</h4>
        </div>
        
        <div class='container d-flex justify-content-center'>
            <table class="table w-50 mb-3">
                <tr>
                    <td><c:out value="Id :"/></td> 
                    <td><c:out value="${funcionario.idUsuario}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Nome :"/></td> 
                    <td><c:out value="${funcionario.nomeUsuario}"/></td> 
                </tr> 
                 <tr>
                    <td><c:out value="CPF :"/></td> 
                    <td><c:out value="${funcionario.cpf}"></c:out></td> 
                </tr>
                 <tr>
                    <td><c:out value="Email :"/></td> 
                    <td><c:out value="${funcionario.email}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Telefone do funcionário :"/></td> 
                    <td><c:out value="${funcionario.telefone}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Rua do Cliente :"/></td> 
                    <td><c:out value="${funcionario.nomeRua}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Número :"/></td> 
                    <td><c:out value="${funcionario.numeroRua}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Complemento :"/></td> 
                    <td><c:out value="${funcionario.complemento}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Bairro:"/></td> 
                    <td><c:out value="${funcionario.bairro}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="CEP :"/></td> 
                    <td><c:out value="${funcionario.cep}"/></td> 
                </tr>
                <tr>
                    <td><c:out value="Cidade :"/></td> 
                    <td><c:out value="${funcionario.cidade.nomeCidade}"/></td> 
                </tr>
                 <tr>
                    <td><c:out value="UF :"/></td> 
                    <td><c:out value="${funcionario.cidade.estado.sigla}"/></td> 
                </tr> 
            </table>
        </div>
                    
         <div class="d-flex justify-content-center">
             <a href='FuncionarioServlet?action=list' class='btn btn-primary col-md-1 ml-2' style='float: right; '>Voltar</a>
         </div>
            <jsp:include page="/footer.jsp"/>
    </body>
</html>