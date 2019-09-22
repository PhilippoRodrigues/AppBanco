<%@page import="negocio.ContaCorrente"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ContaCorrenteLista</title>
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
		List<ContaCorrente> lista = (List<ContaCorrente>) request.getAttribute("contasCorrentes");
	%>

	<c:import url="cabecalho.jsp" />

	<div class="container">
		<h2>Lista de contas-correntes</h2>

		<form action="contaCorrenteCadastro.jsp">
			<input type="hidden" name="operacao" value="CC">
			<button type="submit" class="btn btn-default">Novo</button>
			<hr>
		</form>

		<%
			if (lista != null) {
		%>

		<table class="table table-striped">
			<thead>
				<tr>
					<!-- 					<th>Conta-Corrente</th> -->
					<!-- 					<th></th> -->
					<th>Id</th>
					<th>Agência</th>
					<th>Número da Conta</th>
					<th>Saldo</th>
					<th>Contra-cheque</th>
					<th>Cheque especial</th>
					<th>Financiamento</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<%
					for (ContaCorrente conta : lista) {
				%>

				<tr>
					<td><%=conta.getId()%></td>
					<td><%=conta.getAgencia()%></td>
					<td><%=conta.getNumConta()%></td>
					<td><%=conta.getSaldo()%></td>
					<td><%=conta.getContraCheque()%></td>
					<td><%=conta.getChequeEspecial() ? "Sim" : "Não"%></td>
					<td><%=conta.getFinanciamento() ? "Sim" : "Não"%></td>

					<td><button type="submit" class="btn btn-default">Excluir</button></td>
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
		
		
		<!-- 				<form action="ContaCorrenteController" method="post"> -->
		<%-- 					<input type="hidden" name="id" value="<%=conta.getId()%>"> --%>

		<!-- 					<tr> -->
		<%-- 						<td><%=conta%></td> --%>
		<!-- 					</tr> -->
		<!-- 				</form> -->
		<%-- 				<% --%>
		<!-- // 					} -->
		<%-- 				%>  --%>
		<!-- 			</tbody> -->
		<!-- 		</table> -->
		<%-- 		<% --%>
		<!-- // 			} -->
		<%-- 		%> --%>

		<%-- 				<% --%>
		<!-- 		// } -->
		<%-- 				%> --%>
		<!-- 			</tbody> -->
		<!-- 		</table> -->

		<%-- 		<% --%>
		<!-- // 			} else { -->
		<%-- 		%> --%>
		<!-- 		<p>Nenhuma conta-corrente cadastrada!</p> -->
		<%-- 		<% --%>
		<!-- 		// } -->
		<%-- 		%> --%>

	</div>

</body>
</html>