package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaPoupancaDao;
import negocio.ContaPoupanca;

public class ContaPoupancaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContaPoupancaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("contaPoupancaCadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("lista", ContaPoupancaDao.obterLista());
			request.getRequestDispatcher("contaPoupancaLista.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("idContaBancaria") != null) {

			ContaPoupancaDao.excluir(Integer.valueOf(request.getParameter("idContaBancaria")));
			this.doGet(request, response);
		} else {
			ContaPoupanca cp = new ContaPoupanca(
					request.getParameter("agencia"), 
					request.getParameter("numConta"),
					Float.valueOf(request.getParameter("saldo")), 
					Float.valueOf(request.getParameter("resgate")), 
					request.getParameter("depositoInicial"));

			ContaPoupancaDao.incluir(cp);

			request.setAttribute("mensagem", cp.toString());

			request.setAttribute("titulo", "Conta-Poupança");

			request.setAttribute("controller", "ContaPoupancaController");

			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		}
	}
}
