<%@ page errorPage="erro.jsp" %>
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
        <link rel="stylesheet" type="text/css" href="css/clientForm.css">
        <jsp:include page="/head.jsp"/>

        <c:choose>
            <c:when test="${cliente.idUsuario == null}">
                <c:set var="ac" value="new" />
            </c:when>   
            <c:otherwise>
                <c:set var="ac" value="update" />
            </c:otherwise>
        </c:choose>
    </head> 
    <body>
        <jsp:include page="/nav.jsp"/>
        <section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5";">
            <div class="container">
                <div class="row align-items-center site-hero-inner justify-content-center">
                    <div class="col-md-8 text-center">
                        <div class="mb-5 element-animate">
                            <h1><c:out value="${(ac == \"update\") ? \"Atualização de Dados\" : \"Cadastro\"}"/></h1>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="site-section">
            <div class="container">
                <div class="d-flex justify-content-center">
                    <h4><c:out value="${(ac == \"update\") ? \"Formulário de Edição de Cliente\" : \"Formulário de Cadastro de Novo Cliente\"}"/></h4>
                </div>

                <div class="col-12 d-flex justify-content-center">
                    <div class="col-12">

                        <form class="w-100" action="ClienteServlet?action=${ac}" method="POST">

                            <i class="fas fa-user p-2"></i><label > Nome do cliente: </label>
                            <input class="form-control mb-3" type="text" name="nome" required value="${cliente.nomeUsuario}" minlength="5" maxlength="45"/>

                            <i class="fas fa-envelope p-2"></i> <label> Senha : </label>
                            <input  class="form-control mb-3 email" type="password" name="passwd"  minlength="8" maxlength="8" value="${cliente.password}"/>

                            <i class="fas fa-phone p-2"></i> <label> Telefone: </label>
                            <input  class="form-control mb-3 phone_with_ddd" type="text" name="telefone" required value="${cliente.telefone}" minlength="11" maxlength="11">

                            <i class="fas fa-road p-2"></i> <label> Endereço : </label>
                            <input  class="form-control mb-3" type="text" name="endereco" required value="${cliente.nomeRua}" minlength="5" maxlength="45">

                            <i class="fas fa-search p-2"></i> <label> Número : </label>
                            <input  class="form-control mb-3" type="text" name="nrua" required value="${cliente.numeroRua}">

                            <i class="fas fa-home p-2"></i> <label> Complemento : </label>
                            <input  class="form-control mb-3" type="text" name="complemento" required value="${cliente.complemento}" minlength="5" maxlength="45">

                            <i class="fas fa-map-signs p-2"></i> <label> Bairro : </label>
                            <input  class="form-control mb-3" type="text" name="bairro" required value="${cliente.bairro}" minlength="5" maxlength="45">

                            <i class="fas fa-map-marker-alt p-2"></i> <label> CEP : </label>
                            <input  class="form-control mb-3 cep" type="text" name="cep" required value="${cliente.cep}" minlength="8" maxlength="8">

                            <i class="fas fa-map-signs p-2"></i> <label> Cidade : </label>
                            <input  class="form-control mb-3" type="text" name="cidade" required value="${cliente.cidade}" minlength="5" maxlength="255">
                            <input type="text" name="id" value="${cliente.idUsuario}" hidden>

                            <div class="d-flex justify-content-center mt-5">
                                <a href="/Trabalho-web" class="btn btn-danger w-25 mr-3" type="submit">Cancelar</a>
                                <c:if test="${cliente.idUsuario==null}">
                                    <c:set var="valueButton" value="Save" />

                                </c:if>
                                <c:if test="${cliente.idUsuario!=null}">
                                    <c:set var="valueButton" value="Update" />
                                </c:if>

                                <input class="btn btn-primary w-25 ml-3" type="submit" value="${valueButton}"> 
                            </div>             
                        </form>
                    </div> 
                </div> 
            </div>
        </section>

        <jsp:include page="/footer.jsp"/>
    </body>
</html>
<script src="http://localhost:8080/Trabalho-Web/js/getCidades.js" type="text/javascript"></script>
<script src="http://localhost:8080/Trabalho-Web/js/lib.js" type="text/javascript"></script>