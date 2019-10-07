package br.com.philippo.wallet.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.philippo.wallet.dao.ContaCorrenteDao;
import br.com.philippo.wallet.negocio.ContaCorrente;

public class ContaCorrenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContaCorrenteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("contaCorrenteCadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("lista", ContaCorrenteDao.obterLista());
			request.getRequestDispatcher("contaCorrenteLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("idContaBancaria") != null) {
			
			ContaCorrenteDao.excluir(Integer.valueOf(request.getParameter("idContaBancaria")));
			this.doGet(request, response);
		} else {

		ContaCorrente cc = new ContaCorrente(
				request.getParameter("agencia"), 
				request.getParameter("numConta"),
				Float.valueOf(request.getParameter("saldo")), 
				Float.valueOf(request.getParameter("contraCheque")),
				Boolean.valueOf(request.getParameter("chequeEspecial")),
				Boolean.valueOf(request.getParameter("financiamento")));

		ContaCorrenteDao.incluir(cc);
		
		request.setAttribute("mensagem", cc.toString());

		request.setAttribute("titulo", "Conta-Corrente");

		request.setAttribute("controller", "ContaCorrenteController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		
		}
	}
}