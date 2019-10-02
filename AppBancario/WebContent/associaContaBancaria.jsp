<%@page import="modelo.ContaBancaria"%>
<%@page import="negocio.Titular"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>AppWallet - associação de contas bancárias</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

  <%
  	Titular titular = (Titular) request.getAttribute("titular");
  	Set<ContaBancaria> lista = (Set<ContaBancaria>) request.getAttribute("tiposConta");
  %>

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
              <c:import url="titularVoltar.jsp" />
            </div>

            <div class="btn-group">
              <c:import url="sair.jsp" />
            </div>
          </div>

          <div class="form-group">
            <label for="nome">Nome do titular:</label> <input
              type="text" class="form-control" id="nome" name="nome"
              readonly="readonly" value="<%=titular.getNome()%>">
          </div>

          <div class="form-group">
            <label for="nomeBanco">Nome do Banco:</label> <input
              type="text" class="form-control" id="nomeBanco"
              name="nomeBanco" readonly="readonly"
              value="<%=titular.getNomeBanco()%>">
          </div>

          <div class="form-group">
            <label for="dataAberturaConta">Data da abertura da conta:</label> 
            <input type="text" class="form-control"
              id="dataAberturaConta" name="dataAberturaConta"
              readonly="readonly"
              value="<%=titular.getDataAberturaConta()%>">
          </div>

          <hr>

          <form action="ContaBancariaTitularController" method="post">
            <div class="form-group">

              <%
              	if (lista.size() > 0) {
              %>
              <label>Contas Bancárias:</label>

              <%
              	for (ContaBancaria item : lista) {
              %>
              <div class="container">
                <input type="checkbox" name="tiposConta" value="<%=item.getId()%>"> <%=item%>
              </div>

              <%
              	}

              	} else {
              %>

              <label>Não há Contas Bancárias</label>
              <%
              	}
              %>
            </div>

            <button type="submit" class="btn btn-default" <%=lista.size() == 0 ? "disabled" : ""%>>Cadastrar</button>
          </form>

        </div>
      </div>
    </div>
  </div>

</body>
</html>