<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Documentação</title>
</head>

<body>
  <div class="container">
    <div class="panel-group">
      <div class="panel panel-default">
        <c:import url="cabecalho.jsp" />

        <div class="panel-body">
          <div class="btn-group btn-group-justified">
            <div class="btn-group"></div>

            <div class="btn-group"></div>

            <div class="btn-group"></div>

            <div class="btn-group">
              <form action="DocumentacaoController" method="get">
                <button type="submit" class="btn btn-default">Voltar</button>
              </form>
            </div>
            <div class="btn-group">
              <c:import url="sair.jsp" />
            </div>
          </div>

          <form action="DocumentacaoController" method="post">
            <div class="form-group">
              <label for="rg">RG:</label> <input type="text"
                class="form-control" id="rg"
                placeholder="Digite nesse formato: xx.xxx.xxx-x"
                name="rg">
            </div>
            <div class="form-group">
              <label for="cpf">CPF:</label> <input type="text"
                class="form-control" id="cpf"
                placeholder="Digite nesse formato: xxx.xxx.xxx-xx"
                name="cpf">
            </div>
            <div class="form-group">
              <label for="endereco">Endereço:</label> <input type="text"
                class="form-control" id="endereco:"
                placeholder="Logradouro, número, complemento"
                name="endereco">
            </div>
            <div class="form-group">
              <label for="cep">CEP:</label> <input type="text"
                class="form-control" id="cep:"
                placeholder="Digite nesse formato: xxxxx-xxx" name="cep">
            </div>
            <div class="form-group">
              <label for="telefone">Telefone:</label> <input type="text"
                class="form-control" id="telefone:"
                placeholder="Entre com o valor do contra-cheque"
                name="telefone">
            </div>
            <button type="submit" class="btn btn-default">Cadastrar</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>

</html>