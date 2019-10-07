<%@page import="br.com.philippo.wallet.modelo.ContaBancaria"%>
<%@page import="br.com.philippo.wallet.negocio.Titular"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta de titulares</title>
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

          <form action="" method="get">
            <div class="form-group">
              <label for="nome">Nome:</label> <input type="text"
                class="form-control" id="nome" name="nome"
                readonly="readonly" value="<%=titular.getNome()%>">
            </div>

            <div class="form-group">
              <label for="nomeBanco">Número da conta:</label> <input
                type="text" class="form-control" id="nomeBanco"
                name="nomeBanco" readonly="readonly"
                value="<%=titular.getNomeBanco()%>">
            </div>

            <div class="form-group">
              <label for="dataAberturaConta">Data da abertura da
                conta:</label> <input type="text" class="form-control"
                id="dataAberturaConta" name="dataAberturaConta"
                readonly="readonly"
                value="<%=titular.getDataAberturaConta()%>">
            </div>

            <div class="form-group">
              <%
              	if (titular.getTiposConta() != null ? titular.getTiposConta().size() > 0 : false) {
              %>
              <label>Contas Bancárias:</label>
              <%
              	for (ContaBancaria item : titular.getTiposConta()) {
              %>
              <div class="container">
                <input type="checkbox" disabled checked name="tiposConta">
                <%=item%>
              </div>
              <%
              	}
              	} else {
              %>
              <label>Não há conta cadastrada</label>
              <%
              	}
              %>

            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>