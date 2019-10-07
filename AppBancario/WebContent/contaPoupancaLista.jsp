<%@page import="java.util.List"%>
<%@page import="br.com.philippo.wallet.negocio.ContaPoupanca"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Lista de contas-poupança</title>
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
  	List<ContaPoupanca> lista = (List<ContaPoupanca>) request.getAttribute("lista");
  %>

  <div class="container">
    <div class="panel-group">
      <div class="panel panel-default">

        <c:import url="cabecalho.jsp" />

        <div class="panel-body">
          <div class="btn-group btn-group-justified">
            <div class="btn-group">
              <form action="ContaPoupancaController" method="get">
                <input type="hidden" name="tela" value="CP">
                <button type="submit" class="btn btn-default">Nova Conta-Poupanca</button>
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
                <th>Agência</th>
                <th>Número da conta</th>
                <th>Saldo</th>
                <th>Resgate</th>
                <th>Rendimentos</th>
                <th>Data Inicial de depósito</th>
                <th>Total</th>
              </tr>
            </thead>
            <tbody>
              <%
              	for (ContaPoupanca conta : lista) {
              %>
              <tr>
                <td><%=conta.getId()%></td>
                <td><%=conta.getAgencia()%></td>
                <td><%=conta.getNumConta()%></td>
                <td><%=conta.getSaldo()%></td>
                <td><%=conta.getResgate()%></td>
                <td><%=conta.getTaxaRendimentos()%></td>
                <td><%=conta.getDepositoInicial()%></td>
                <td><%=conta.getTotal()%></td>

                <form action="ContaPoupancaController" method="post">
                  <input type="hidden" name="idContaBancaria"
                    value="<%=conta.getId()%>">
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