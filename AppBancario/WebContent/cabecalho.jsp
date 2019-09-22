<%@page import="negocio.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AppBanco</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	
	<% Usuario usuario = (Usuario)session.getAttribute("usuario");%>
	<div class="container">
	<div class="panel-heading">
		<h2>Conta bancaria cadastrada</h2>
		<h3>Ola, <%=usuario.getNome() %></h3>
		<form action="login.jsp">
		   		<button type="submit" class="btn btn-link">Sair</button>
		</form>
	
	</div>
	</div>
</body>
</html>