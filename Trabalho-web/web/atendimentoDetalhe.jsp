<%@ page errorPage="erro.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/validationLoginBean.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head><jsp:include page="/head.jsp"/></head>
    <body>
        <jsp:include page="/nav.jsp" />

        <div class='d-flex justify-content-center m-5'>
            <div class='align-self-center'>
               <h4>Dados do atendimento</h4>
            </div>
        </div>

        <div class='container mt-5 d-flex justify-content-center'>
            <table class="table w-50">
                <tr>
                    <td><c:out value="Id :"/></td>
                    <td><c:out value="${atendimento.idAtendimento}"/></td>
                </tr>
                <tr>
                    <td><c:out value="Data de atendimento :"/></td>
                    <td>
                        <fmt:parseDate value="${ atendimento.dataHoraAtendimento }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                        <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }" />
                    </td>
                </tr>
                <tr>
                    <td><c:out value="Atendimento Resolvido:"/></td>
                    <td><c:out value="${atendimento.situacao}"></c:out></td>
                    </tr>
                    <tr>
                        <td><c:out value="Descrição :"/></td>
                    <td><c:out value="${atendimento.descricaoAtendimento}"/></td>
                </tr>
                <tr>
                    <td><c:out value="Tipo de atendimento :"/></td>
                    <td><c:out value="${atendimento.tipoAtendimento.nomeTipoAtendimento}"/></td>
                </tr>
                <tr>
                    <td><c:out value="Produto :"/></td>
                    <td><c:out value="${atendimento.produto.nomeProduto}"/></td>
                </tr>
                <tr>
                    <td><c:out value="Nome do cliente"/></td>
                    <td><c:out value="${atendimento.usuario.nomeUsuario}"/></td>
                </tr>
                <tr>
                    <td><c:out value="Solução Apresentada p/ atendimento"/></td>
                    <td><c:out value="${atendimento.solucaoApresentada}"/></td>
                </tr>


            </table>
        </div>

        <div class="d-flex justify-content-center">
            <a href='AtendimentoServlet?action=list' class='btn btn-primary col-1 ml-2' style='float: right; '>Voltar</a>
        </div>

        <jsp:include page="/footer.jsp" />
        <jsp:include page="/modalRemove.jsp" />

    </body>
</html>

<script>
    $("#save").click(function() {

        var idAtendimento = $("#idAtendimento").val();
        var id = "action=remove" + "&id=" + idAtendimento;

        $('#myModal').modal('hide');
        $.ajax({
            type: "GET",
            url: "AtendimentoServlet",
            data: id,
            success: function(result) {
                window.location.replace("/Trabalho-Web/AtendimentoServlet?action=list");
            },
            error: function(error) {
                console.log("error" + error);
            }
        });
    });</script>
