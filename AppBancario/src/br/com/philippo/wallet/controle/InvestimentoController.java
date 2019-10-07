package br.com.philippo.wallet.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.philippo.wallet.dao.InvestimentoDao;
import br.com.philippo.wallet.negocio.Investimento;

public class InvestimentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InvestimentoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("investimentoCadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("lista", InvestimentoDao.obterLista());
			request.getRequestDispatcher("investimentoLista.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("idContaBancaria") != null) {

			InvestimentoDao.excluir(Integer.valueOf(request.getParameter("idContaBancaria")));
			this.doGet(request, response);
		} else {
			Investimento inv = new Investimento(
					request.getParameter("agencia"), 
					request.getParameter("numConta"),
					Float.valueOf(request.getParameter("saldo")), 
					request.getParameter("tipo"),
					Float.valueOf(request.getParameter("resgateInv")),
					Float.valueOf(request.getParameter("quantiaInicialInv"))
			);

			InvestimentoDao.incluir(inv);

			request.setAttribute("mensagem", inv.toString());

			request.setAttribute("titulo", "Contas de Investimentos");

			request.setAttribute("controller", "InvestimentoController");

			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		}
	}
}
