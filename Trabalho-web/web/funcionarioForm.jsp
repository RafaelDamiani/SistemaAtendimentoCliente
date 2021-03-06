<%@include file="/validationLoginBean.jsp"%>
<%@ page errorPage="erro.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/head.jsp"/>

        <c:choose>
            <c:when test="${funcionario.idUsuario == null}">
                <c:set var="ac" value="new" />
            </c:when>   
            <c:otherwise>
                <c:set var="ac" value="update" />
            </c:otherwise>
        </c:choose>
    </head> 
    <body>
        <jsp:include page="/nav.jsp"/>

        <section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5" style="background-image: url(http://localhost:8080/Trabalho-Web/big_image_1.jpg);">
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

        <section class="site-section bg-light">
            <div class="container mt-5">
                <div class="d-flex justify-content-center">
                    <h4><c:out value="${(ac == \"update\") ? \"Formulário de Atualização de Dados\" : \"Formulário de Cadastro de Novo Funcionário\"}"/></h4>
                </div>

                <div class="col-12 d-flex justify-content-center">
                    <div class="col-12">

                        <form class="w-100" action="FuncionarioServlet?action=${ac}" method="POST">

                            <i class="fas fa-user p-2"></i><label > Nome do funcionário: </label>
                            <input class="form-control mb-3" type="text" name="nome" required value="${funcionario.nomeUsuario}" minlength="5" maxlength="45"/>

                            <i class="fas fa-passport p-2"></i><label> CPF do funcionário : </label>
                            <input  class="form-control mb-3 cpf" type="text" name="cpf" required value="${funcionario.cpf}" minlength="11" maxlength="11"/>

                            <i class="fas fa-envelope p-2"></i> <label> Email do funcionário : </label>
                            <input  class="form-control mb-3 email" type="text" name="email" required value="${funcionario.email}"/>

                            <i class="fas fa-envelope p-2"></i> <label> Senha : </label>
                            <input  class="form-control mb-3 email" type="password" name="passwd" required  minlength="8" maxlength="8" value="${funcionario.password}"/>

                            <i class="fas fa-road p-2"></i> <label> Telefone: </label>
                            <input  class="form-control mb-3 phone_with_ddd" type="text" name="telefone" required value="${funcionario.telefone}" minlength="11" maxlength="11">

                            <i class="fas fa-road p-2"></i> <label> Endereço : </label>
                            <input  class="form-control mb-3" type="text" name="endereco" required value="${funcionario.nomeRua}" minlength="5" maxlength="45">

                            <i class="fas fa-unlock p-2"></i> <label> Número : </label>
                            <input  class="form-control mb-3" type="text" name="nrua" required value="${funcionario.numeroRua}">

                            <i class="fas fa-road p-2"></i> <label> Complemento : </label>
                            <input  class="form-control mb-3" type="text" name="complemento" required value="${funcionario.complemento}" minlength="5" maxlength="45">

                            <i class="fas fa-road p-2"></i> <label> Bairro : </label>
                            <input  class="form-control mb-3" type="text" name="bairro" required value="${funcionario.bairro}" minlength="5" maxlength="45">

                            <i class="fas fa-map-marker-alt p-2"></i> <label> CEP : </label>
                            <input  class="form-control mb-3 cep" type="text" name="cep" required value="${funcionario.cep}" minlength="8" maxlength="8">

                            <i class="fas fa-map-signs p-2"></i> <label> Cidade : </label>
                            <input  class="form-control mb-3" type="text" name="cidade" required value="${funcionario.cidade}" minlength="5" maxlength="255">
                            
                            <i class="fas fa-city p-2"></i> <label for="cargo"> Cargo : </label>
                            <select class="form-control mb-3" type="text" id="cargo" name="cargo">
                                <option value="Funcionario">Funcionário</option>
                                <option value="Gerente">Gerente</option>
                            </select>
                            <input type="text" name="id" value="${funcionario.idUsuario}" hidden>

                            <div class="d-flex justify-content-center mt-5">
                                <a href="http://localhost:8080/Trabalho-Web/FuncdionarioServlet?action=list" class="btn btn-danger w-25 mr-3" type="submit">Cancelar</a>
                                <c:if test="${funcionario.idUsuario==null}">
                                    <c:set var="valueButton" value="Save" />

                                </c:if>
                                <c:if test="${funcionario.idUsuario!=null}">
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
