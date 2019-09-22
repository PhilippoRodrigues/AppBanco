<%@page import="negocio.Investimento"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Investimentos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<%-- 	<% --%>
	<!-- // 		Investimento inv = (Investimento) session.getAttribute("novoInv"); -->
	<%-- 	%> --%>
	<div class="container">
		<h2>Simulação:</h2>
		<form action="InvestimentoController" method="post">

			<div class="form-group">
				<label for="agencia">Agência:</label> <input type="text"
					class="form-control" id="agencia"
					name="agencia">
			</div>

			<div class="form-group">
				<label for="numConta">Número da Conta:</label> <input type="text"
					class="form-control" id="numConta"
					name="numConta">
			</div>

			<div class="form-group">
				<label for="saldo">Saldo:</label> <input type="text"
					class="form-control" id="saldo"
					name="saldo">
			</div>

			<div class="form-group">
				<label for="tipo">Tipo de Investimento:</label> <select
					class="form-control" name="tipo">
					<option value="CDB">CDB</option>
					<option value="CDB-DI">CDB-DI</option>
					<option value="LFT">LFT</option>
				</select>
			</div>

			<!-- 			<div class="form-group"> -->
			<!-- 				<label for="tipo">Tipo de Investimento:</label> <select -->
			<!-- 					class="form-control" id="tipo" name="tipo"> -->
			<!-- 					<option>CDB</option> -->
			<!-- 					<option>CDB-DI</option> -->
			<!-- 					<option>LFT</option> -->
			<!-- 				</select> <br> -->
			<!-- 			</div> -->
			<div class="form-group">
				<label for="resgateInv">Resgate:</label> <input type="text"
					class="form-control" id="resgateInv"
					placeholder="Informe o valor do resgate" name="resgateInv">
			</div>
			<div class="form-group">
				<label for="quantiaInicialInv">Quantia inicial de
					investimento:</label> <input type="text" class="form-control"
					id="quantiaInicialInv"
					placeholder="Informe a quantia inicial de investimento"
					name="quantiaInicialInv">
			</div>
			
			<button type="submit" class="btn btn-default">Cadastrar</button>
			
		</form>
<!-- 		<form action="finalizaInv.jsp"> -->
<!-- 			<button type="submit" class="btn btn-default">Cadastrar</button> -->
<!-- 		</form> -->
	</div>
	<hr>
</body>
</html>