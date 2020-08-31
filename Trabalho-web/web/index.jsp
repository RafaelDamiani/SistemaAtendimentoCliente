<%@ page errorPage="erro.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Cabeleleira Leila</title>
	<jsp:include page="/head.jsp"/>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/album/">

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="album.css" rel="stylesheet">
  </head>
  
  
    <body>
        <jsp:include page="/nav.jsp"/>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <a class="navbar-brand" href="#">Cabeleleila Leila</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			</li>
                    </ul>

		<form class="form-inline mt-2 mt-md-0">
                    <a class="nav-item nav-link active text-white" href="http://localhost:8080/Trabalho-web/login.jsp" class="sr-only">Login</a>
                    <a class="nav-item nav-link active text-white" href="http://localhost:8080/Trabalho-web/ClienteServlet?action=formNew" class="sr-only">Cadastre-se</a>
		</form>
		</div>
            </nav>
	</header>

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1>Cabeleleira Leila</h1>
      <p class="lead text-muted">Única filial AUTORIZADA da Leila Cabeleleilos</p>
     </div>
  </section>

  <div class="album py-5 bg-light">
    <div class="container">

      <div class="row">
        <div class="col-md-3">
          <div class="card mb-3 shadow-sm">
            <img src="https://images.unsplash.com/flagged/photo-1580820258381-20c91a156841?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80"  class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"/>
            <div class="card-body">
              <h4>Cabelos</h4>
              <p class="card-text">Venha hidratar as suas madeixas conosco!</p>
              <div class="d-flex justify-content-between align-items-center">
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card mb-3 shadow-sm">
            <img src="https://images.unsplash.com/photo-1519014816548-bf5fe059798b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"  class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"/>
            <div class="card-body">
              <h4>Unhas</h4>
              <p class="card-text">Tudo esterilizado para sua maior segurança!</p>
              <div class="d-flex justify-content-between align-items-center">
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card mb-3 shadow-sm">
            <img src="https://images.unsplash.com/photo-1495638488670-437e54b3bab4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"  class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"/>
            <div class="card-body">
              <h4>Hidratação</h4>
              <p class="card-text">Que tal hidratar essa palha aí?</p>
              <div class="d-flex justify-content-between align-items-center">
              </div>
            </div>
          </div>
        </div>

        <div class="col-md-3">
          <div class="card mb-3 shadow-sm">
            <img src="https://images.unsplash.com/photo-1457972729786-0411a3b2b626?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"  class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"/>
            <div class="card-body">
              <h4>Unhas</h4>
              <p class="card-text">Faça suas unhas com a nossa equipe e não se arrependa!</p>
              <div class="d-flex justify-content-between align-items-center">
              </div>
            </div>
          </div>
        </div>
        </div>
      </div>
    </div>
  </div>

</main>

<footer class="text-muted">
  <div class="container">
    <p>Todos os direitos reservados | Leila Cabeleleleilos &copy;</p>
    <p>Rua do Embuste, 1313 - Curitiba, PR, 13131-313 - (41) 9 1313-1313</p>
  </div>
</footer>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.min.js"></script>                                                
</html>