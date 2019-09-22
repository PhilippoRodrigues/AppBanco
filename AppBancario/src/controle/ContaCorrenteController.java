package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaCorrenteDao;
import negocio.ContaCorrente;

public class ContaCorrenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private ContaCorrente cc;

	public ContaCorrenteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("contasCorrentes", ContaCorrenteDao.obterLista());
		
		request.getRequestDispatcher("contaCorrenteLista.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//cc = (ContaCorrente) request.getSession().getAttribute("novaCC");

		//cc.setContraCheque(Float.valueOf(request.getParameter("contraCheque")));
		
		ContaCorrente cc = new ContaCorrente(
				request.getParameter("agencia"),
				request.getParameter("numConta"),
				Float.valueOf(request.getParameter("saldo")),
				Float.valueOf(request.getParameter("contraCheque")),
				Boolean.valueOf(request.getParameter("chequeEspecial")),
				Boolean.valueOf(request.getParameter("financiamento"))
		);

		ContaCorrenteDao.incluir(cc);
		
		request.setAttribute("mensagem", cc.toString());

		request.setAttribute("titulo", "Conta-Corrente");
		
		request.setAttribute("controller", "ContaCorrenteController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		
	}
}