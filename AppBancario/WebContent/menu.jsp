<%@page import="negocio.Titular"%>
<%@page import="modelo.ContaBancaria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>appBancario</title>
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
		List<Titular> lista = (List<Titular>) request.getAttribute("titulares");
	%>

	<c:import url="cabecalho.jsp" />
	<div class="container">
		<div class="btn-group btn-group-justified">

			<div class="btn-group">
				<form action="ContaCorrenteController">
					<button type="submit" class="btn btn-primary">Conta-Corrente</button>
				</form>
			</div>

			<div class="btn-group">
				<form action="ContaPoupancaController">
					<button type="submit" class="btn btn-primary">Conta-Poupança</button>
				</form>
			</div>

			<div class="btn-group">
				<form action="InvestimentoController">
					<button type="submit" class="btn btn-primary">Investimento</button>
				</form>
			</div>

			<div class="btn-group">
				<form action="DocumentacaoController">
					<button type="submit" class="btn btn-primary">Documentação</button>
				</form>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-body">
			<h3>
				<b>Lista de Titulares:</b>
			</h3>
			<br>

			<%
				if (lista != null) {
			%>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Nome do Banco</th>
						<th>Data da Abertura de Conta</th>
					</tr>
				</thead>
				<tbody>

					<%
						for (Titular item : lista) {
					%>
					<tr>
						<td><%=item.getNome()%></td>
						<td><%=item.getNomeBanco()%></td>
						<td><%=item.getDataAberturaConta()%></td>
						<td></td>
						<td></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			<%
				} else {
			%>
			<p>Não há contas bancárias cadastradas</p>
			<%
				}
			%>

		</div>
	</div>
</body>
</html>

