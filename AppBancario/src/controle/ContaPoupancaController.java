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

//	private ContaPoupanca cp;

	public ContaPoupancaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("contasPoupanca", ContaPoupancaDao.obterLista());

		request.getRequestDispatcher("contaPoupancaLista.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContaPoupanca cp = new ContaPoupanca(
				request.getParameter("agencia"),
				request.getParameter("numConta"),
				Float.valueOf(request.getParameter("saldo")),
				Float.valueOf(request.getParameter("rendimentos")),
				Float.valueOf(request.getParameter("resgate")),
				request.getParameter("depositoInicial")
		);
		
		
//		cp = (ContaPoupanca) request.getSession().getAttribute("novaCP");
//
//		cp.setRendimentos(Float.valueOf(request.getParameter("rendimentos")));
//		cp.setResgate(Float.valueOf(request.getParameter("resgate")));
//		cp.setDepositoInicial(request.getParameter("depositoInicial"));

		ContaPoupancaDao.incluir(cp);

//		ContaBancariaController cbController = new ContaBancariaController();
//		cbController.doGet(request, response);
		
		request.setAttribute("mensagem", cp.toString());

		request.setAttribute("titulo", "Conta-Poupança");
		
		request.setAttribute("controller", "ContaPoupancaController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
