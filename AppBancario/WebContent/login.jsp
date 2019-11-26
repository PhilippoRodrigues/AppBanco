<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>AppBanco</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/estilos-login.css" />
</head>
<body>
	<header>
		<div class="container cabecalho">
			<h2>My Wallet</h2>
			<img alt="imagem carteira" src="imagens/wallet.jpg">
		</div>

	</header>

	<main>

		<%
			boolean invalido = false;
			if (request.getAttribute("invalido") != null) {
				invalido = (Boolean) request.getAttribute("invalido");
			}
		%>

		<div class="container titulo">
			Olá, <b>Fulano</b>! Bem-vindo ao <b>MyWallet</b>!
		</div>

		<%
			if (invalido) {
		%>
		<div class="container">
			<div class="alert alert-danger">
				<strong>Problema!</strong> Usuário não encontrado :'(
			</div>
		</div>
		<%
			}
		%>

		<section class="formulario">

			<form action="AcessoController" method="post">
				<div class="form-group">
					<label for="email">E-mail:</label> <input type="email"
						class="form-control" id="email" placeholder="Entre com o e-mail"
						name="email">
				</div>

				<div class="form-group">
					<label for="senha">Senha:</label> <input type="password"
						class="form-control" id="senha" placeholder="Entre com a senha"
						name="senha">
				</div>

				<button type="submit" class="btn btn-default">Acessar</button>
			</form>
		</section>
	</main>

	<footer>
		<p class="copyright">&copy; Copyright MyWallet - 2019</p>
	</footer>

</body>
</html>
