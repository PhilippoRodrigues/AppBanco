<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>CadastroDeContas</title>
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

	<div class="container">
		<h2>Cadastro:</h2>
		<form action="ContaBancariaController" method="post">
			<div class="form-group">
				<label for="agencia">Agência:</label> <input type="text"
					class="form-control" id="agencia" name="agencia">
			</div>
			<div class="form-group">
				<label for="numConta">Número da Conta:</label> <input type="text"
					class="form-control" id="numConta" name="numConta">
			</div>

			<div class="form-group">
				<label for="saldo">Saldo:</label> <input type="text"
					class="form-control" id="saldo" name="saldo">
			</div>
			<div class="form-group">
				<label for="tipo">Selecione uma opção para cadastro:</label> <select
					class="form-control" name="tipo">
					<option value="CC">Conta-Corrente</option>
					<option value="CP">Conta-Poupança</option>
					<option value="INV">Investimento</option>
				</select>
			</div>

			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>
</body>
</html>