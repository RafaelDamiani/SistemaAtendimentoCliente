<%@ page errorPage="erro.jsp" %>
<%@include file="/validationLoginBean.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- END header -->
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
        <section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5" style="background-image: url(http://localhost:8080/Trabalho-Web/images/big_image_1.jpg);">
            <div class="container">
                <div class="row align-items-center site-hero-inner justify-content-center">
                    <div class="col-md-8 text-center">
                        <div class="mb-5 element-animate">
                            <h1>Lista de Funcionários Beibe</h1>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="site-section bg-light">
            <div class='d-flex justify-content-center m-5'>
                <c:choose>
                    <c:when test="${empty listaFuncionarios}" >
                        <div class="text-center">
                            <p class="m-5">O sistema não possui funcionarios cadastrados no momento. Se desejar cadastre um novo funcionario agora mesmo!</p>  
                        </div>    
                    </c:when>
                    <c:otherwise>                  
                          <table class='table w-75 text-center'>    
                                <tr>
                                    <th>Id Funcionário</th>
                                    <th>Nome do funcionário</th>
                                    <th>CPF</th>
                                    <th>Email</th>
                                    <th>Cargo</th>
                                    <th style="width: 20%">Ver/Editar/Excluir</th>
                                </tr>

                                <c:forEach items="${listaFuncionarios}" var="funcionario">
                                    <tr>
                                        <td><c:out value="${funcionario.idUsuario}"/></td>
                                        <td><c:out value="${funcionario.nomeUsuario}"/></td>
                                        <td><c:out value="${funcionario.cpf}"/></td>
                                        <td><c:out value="${funcionario.email}"/></td>
                                        <td><c:out value="${funcionario.tipoUsuario}"/></td>

                                        <td style="width: 20%"> 
                                            <a class="button" href="FuncionarioServlet?action=show&id=${funcionario.idUsuario}" class="mr-1"><button><i class="far fa-eye fa-2x"></i></button></a>
                                            <a class="button" href="FuncionarioServlet?action=formUpdate&id=${funcionario.idUsuario}" class="mr-1"><button><i class="far fa-edit fa-2x"></button></i></a>
                                            <c:if test="${loginBean.id != funcionario.idUsuario}">
                                               <a href="#" data-toggle="modal" data-target="#myModal" ><button onclick="deleteId(${funcionario.idUsuario})"  ><i class="far fa-trash-alt fa-2x"></i></button></a>  
                                            </c:if>
                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </c:otherwise> 
                </c:choose>

                <div class="d-flex justify-content-center">
                    <a href='../FuncionarioServlet?action=formNew' class='btn btn-primary col-md-1 ml-2'>Cadastrar Funcionário</a>
                </div>

                <jsp:include page="/modalRemove.jsp"/>
                <jsp:include page="/footer.jsp" />
    </body>
</html>
<script>
function deleteId(numero)
    {

        $("#save").click(function() {
            var idFuncionario = numero;

            var id = "action=remove" + "&id=" + idFuncionario;
            $('#myModal').modal('hide');
            $.ajax({
                type: "GET",
                url: "ProdutoServlet",
                data: id,
                success: function(result) {
                    location.reload();

                },
                error: function(error) {
                    console.log("error" + error);
                }
            });
        });
    }
</script>
