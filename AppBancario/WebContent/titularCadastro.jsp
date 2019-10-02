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

  <c:import url="cabecalho.jsp" />

  <div class="container">
    <h2>Cadastro de Documentação:</h2>

    <form action="TitularController" method="get">
      <button type="submit" class="btn btn-default">Voltar</button>
    </form>
    
    <br>

    <div class="btn-group-default">
      <c:import url="sair.jsp" />
    </div>

    <form action="TitularController" method="post">
      <div class="form-group">
        <label for="nome">Nome do titular:</label> <input type="text"
          class="form-control" id="nome" name="nome">
      </div>
      <div class="form-group">
        <label for="nomeBanco">Nome do Banco:</label> <input type="text"
          class="form-control" id="nomeBanco" name="nomeBanco">
      </div>
      <div class="form-group">
        <label for="dataAberturaConta">Data da abertura da
          conta:</label> <input type="text" class="form-control"
          id="dataAberturaConta" name="dataAberturaConta">
      </div>
      <button type="submit" class="btn btn-default">Cadastrar</button>
    </form>
  </div>
  <hr>
</body>

</html>