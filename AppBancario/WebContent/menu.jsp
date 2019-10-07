<%@page import="br.com.philippo.wallet.negocio.Titular"%>
<%@page import="br.com.philippo.wallet.modelo.ContaBancaria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>appBancario</title>
<meta charset="utf-8">

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

  <nav class="navbar navbar-default navbar-fixed-top"
    style="background-color: #5085A5">
    <div class="container">
      <div class="navbar-header">

        <div style="color: #DDEAEA">
          <button type="button" class="navbar-toggle"
            data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span> <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>

        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav navbar-left">
            <li><a href="ContaCorrenteController"> <font
                color="#E5ECEC">Conta-Corrente</font>
            </a></li>
            <li><a href="ContaPoupancaController"> <font
                color="#E5ECEC">Conta-Poupança</font>
            </a></li>
            <li><a href="InvestimentoController"> <font
                color="#E5ECEC">Investimento</font>
            </a></li>
            <li><a href="DocumentacaoController"> <font
                color="#E5ECEC">Documentação</font>
            </a></li>
          </ul>
        </div>
      </div>
    </div>
  </nav>

  <br>


  <div class="panel-body">
    <div class="btn-group">
      <form action="TitularController" method="get">
        <button type="submit" class="btn btn-default" name="tela"
          value="titularCadastro">Novo Titular</button>
      </form>
    </div>
    <div class="btn-group">
      <c:import url="sair.jsp" />
    </div>
  </div>

  <%
  	if (lista.size() > 0) {
  %>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Nome do Banco</th>
        <th>Data da Abertura de Conta</th>
        <th>Documentação</th>
        <th>Total</th>
      </tr>
    </thead>
    <tbody>

      <%
      	for (Titular item : lista) {
      %>
      <tr>
        <td><%=item.getId()%></td>
        <td><%=item.getNome()%></td>
        <td><%=item.getNomeBanco()%></td>
        <td><%=item.getDataAberturaConta()%></td>
        <td><%=item%></td>
        <td><%=item.getTiposConta() == null ? 0 : item.getTiposConta().size()%></td>

        <td>
          <form action="DocumentacaoTitularController" method="get">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <button type="submit" class="btn btn-default">Documentação</button>
          </form>
        </td>

        <td>
          <form action="ContaBancariaTitularController" method="get">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <button type="submit" class="btn btn-default">Contas
              Bancárias</button>
          </form>
        </td>

        <td>
          <form action="ConsultaTitularController" method="get">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <button type="submit" class="btn btn-default">Detalhar</button>
          </form>
        </td>

        <td>
          <form action="ExcluirTitularController" method="post">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <button type="submit" class="btn btn-default">Excluir</button>
          </form>
        </td>
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

</body>

</html>