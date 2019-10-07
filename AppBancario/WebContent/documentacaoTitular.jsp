<%@page import="br.com.philippo.wallet.negocio.Documentacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.philippo.wallet.negocio.Titular"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>AppWallet - Documentação</title>
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
  	List<Documentacao> lista = (List<Documentacao>) request.getAttribute("documentacoes");
  	int idDocumentacao = titular.getDocumentacao() != null ? titular.getDocumentacao().getId() : 0;
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
            <label for="dataAberturaConta">Data da abertura da
              conta:</label> <input type="text" class="form-control"
              id="dataAberturaConta" name="dataAberturaConta"
              readonly="readonly"
              value="<%=titular.getDataAberturaConta()%>">
          </div>
        </div>

        <hr>

        <form action="DocumentacaoTitularController" method="post">
          <div class="form-group">

            <%
            	if (lista.size() > 0) {
            %>
            <label for="documentacao">Documentação:</label> <select
              class="form-control" name="idDocumentacao">

              <%
              	for (Documentacao item : lista) {
              %>
              <option
                <%=idDocumentacao == item.getId() ? "selected" : ""%>
                value="<%=item.getId()%>"><%=item%></option>

              <%
              	}
              %>

            </select>

            <%
            	} else {
            %>

            <label>Não há documentação</label>
            <%
            	}
            %>
          </div>

          <button type="submit" class="btn btn-default"
            <%=lista.size() == 0 ? "disabled" : ""%>>Cadastrar</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>