<%@page import="dao.ContaBancariaDao"%>
<%@page import="negocio.ContaCorrente"%>
<%@page import="modelo.ContaBancaria"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>contaBancariaLista</title>
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
		List<ContaBancaria> lista = (List<ContaBancaria>) request.getAttribute("contasBancarias");
	%>
	
	<c:import url="cabecalho.jsp"/>
	
	<div class="container">
		<h2>Cadastramento de Contas</h2>

		<form action="ContaBancariaController" method="get">
			<input type="hidden" name="operacao" value="new">
			<button type="submit" class="btn btn-default">Novo</button>
		</form>
		<hr>

		<%
			if (lista != null) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Agência</th>
					<th>Número da Conta</th>
					<th>Saldo</th>
					<th>Tipo de conta</th>
				</tr>
			</thead>
			<tbody>

				<!-- <%-- 				<c:forEach var="item" items="${lista}"> --%> -->

				<!-- 					<tr> -->
				<!-- <%-- 						<td>${item.id}</td> --%>
				<%-- 						<td>${item.agencia}</td> --%>
				<%-- 						<td>${item.numConta}</td> --%>
				<%-- 						<td>${item.saldo}</td> --%>
				<%-- 				</c:forEach> --%> -->

				<!-- <%-- 				<c:choose> --%>
				<%-- 					<c:when test="item instanceof ContaCorrente"> --%> -->
				<!-- 					item = "Conta-Corrente" -->
				<!-- <%-- 					</c:when> --%> -->

				<!-- <%-- 					<c:when test="item instanceof ContaPoupanca"> --%> -->
				<!-- 					item = "Conta-Poupança" -->
				<!-- <%-- 					</c:when> --%> -->


				<!-- <%-- 					<c:when test="item instanceof Investimento"> --%> -->
				<!-- 					item = "Investimento" -->
				<!-- <%-- 					</c:when> --%> -->
				<!-- <%-- 				</c:choose> --%> -->

				<!-- 				</tr> -->

				<%
					for (ContaBancaria item : lista) {
				%>
				<tr>
					<td><%=item.getId()%></td>
					<td><%=item.getAgencia()%></td>
					<td><%=item.getNumConta()%></td>
					<td><%=item.getSaldo()%></td>
					<td><%=item.obterTipo()%></td>

					<!-- <form action="ContaBancariaController" method="get">
 						<input type="hidden" name="id" value="${item.id}"> 
						<td><button type="submit" class="btn btn-default">Excluir</button></td>
					</form> -->

				</tr>

				<%
					}
				%>

			</tbody>
		</table>
		<%
			} else {
		%>
		<p>Nenhuma conta cadastrada!</p>
		<%
			}
		%>
	</div>
</body>
</html>