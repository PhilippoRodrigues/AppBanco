<%@page import="negocio.Investimento"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>InvestimentoLista</title>
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
		List<Investimento> lista = (List<Investimento>) request.getAttribute("investimentos");
	%>
	
	<c:import url="cabecalho.jsp" />

	<div class="container">
		<h2>Lista de Contas investimento</h2>
		<form action="investimentoCadastro.jsp">
			<input type="hidden" name="operacao" value="new">
			<button type="submit" class="btn btn-default">Novo</button>
			<hr>
		</form>
		<hr>
		<p>Investimentos:</p>

		<%
			if (lista != null) {
		%>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Agência</th>
					<th>Número da Conta-Investimento</th>
					<th>Saldo</th>
					<th>Tipo de Investimento</th>
					<th>Resgate</th>
					<th>Quantia Inicial de Investimento</th>
					<th>Imposto relativo ao resgate do investimento</th>
					<th>Taxa de Rendimento</th>
					<th>Rendimentos</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Investimento inv : lista) {
				%>
				<tr>
					<td><%=inv.getId()%></td>
					<td><%=inv.getAgencia()%></td>
					<td><%=inv.getNumConta()%></td>
					<td><%=inv.getSaldo()%></td>
					<td><%=inv.getTipo()%></td>
					<td><%=inv.getResgateInv()%></td>
					<td><%=inv.getQuantiaInicialInv()%></td>
					<td><%=inv.getImpostoResgateInv()%></td>
					<td><%=inv.getTaxaRendimentoInv()%></td>
					<td><%=inv.getRendimentosInv()%></td>
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
</body>
</html>