<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        -->
        <!-- Optional theme -->
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        -->


        <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Lista de Clientes</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="ClienteServlet?action=">Auto-cadastro</a></li>
                        <li><a href="LogoutServlet">Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="main" class="container-fluid">
            

            <h3 class="page-header"></h3>
            <h3 class="page-header">Auto-cadastro></h3>
           <!--<form action="AutoCadastro" method="POST"><br/>
               Nome: <input type="text" name="nome" /> <br/>
               E-mail: <input type="text" name="email" /> <br/>
               Senha: <input type="password" name="senha" /> <br/>
               <input type="reset" value="Limpar"/> <br/>
               <input type="submit" value="Salvar"/> <br/>
           </form>   -->
           
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="inputNome">Nome</label>
                        <input type="text" class="form-control" name="nome" placeholder="Digite o nome">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputEmail1">E-mail</label>
                        <input type="email" class="form-control"  name="email" placeholder="Digite o E-mail">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control"  name="senha" >
                    </div>
                </div>
              

                <hr />

                <div class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <a href="ClientesServlet?action=" class="btn btn-default">Cancelar</a>
                    </div>
                </div>

            </form>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
