<%@page import="java.util.List"%>
<%@page import="negocio.Documentacao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>DocumentacaoLista</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

  <%
  	List<Documentacao> lista = (List<Documentacao>) request.getAttribute("lista");
  %>

  <div class="container">
    <div class="panel-group">
      <div class="panel panel-default">
        <c:import url="cabecalho.jsp" />

        <div class="panel-body">
          <div class="btn-group btn-group-justified">
            <div class="btn-group">
              <form action="DocumentacaoController" method="get">
                <input type="hidden" name="tela" value="Documentacao">
                <button type="submit" class="btn btn-default">Nova Documentação</button>
              </form>
            </div>

            <div class="btn-group"></div>

            <div class="btn-group"></div>

            <div class="btn-group">
              <c:import url="titularVoltar.jsp" />
            </div>

            <div class="btn-group">
              <c:import url="sair.jsp" />
            </div>
          </div>

          <%
          	if (lista != null) {
          %>

          <table class="table table-striped">
            <thead>
              <tr>
                <th>Id</th>
                <th>RG</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>CEP</th>
                <th>Telefone</th>
              </tr>
            </thead>
            <tbody>
              <%
              	for (Documentacao doc : lista) {
              %>
              <tr>
                <td><%=doc.getId()%></td>
                <td><%=doc.getRg()%></td>
                <td><%=doc.getCpf()%></td>
                <td><%=doc.getEndereco()%></td>
                <td><%=doc.getCep()%></td>
                <td><%=doc.getTelefone()%></td>

                <form action="DocumentacaoController" method="post">
                  <input type="hidden" name="id"
                    value="<%=doc.getId()%>">
                    <td><button type="submit" class="btn btn-default">Excluir</button></td>
                </form>

              </tr>

              <%
              	}
              %>
            </tbody>
          </table>

          <%
          	} else {
          %>

          <p>Não há cadastro!</p>

          <%
          	}
          %>

        </div>

      </div>
    </div>
  </div>
</body>

</html>