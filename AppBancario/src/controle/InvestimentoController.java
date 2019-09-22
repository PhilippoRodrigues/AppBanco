package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InvestimentoDao;
import negocio.Investimento;

public class InvestimentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private Investimento inv;

	public InvestimentoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("investimentos", InvestimentoDao.obterLista());

		request.getRequestDispatcher("investimentoLista.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		inv = (Investimento) request.getSession().getAttribute("novoInv");
//
//		inv.setTipo(request.getParameter("tipo"));
//		inv.setResgateInv(Float.valueOf(request.getParameter("resgateInv")));
//		inv.setQuantiaInicialInv(Float.valueOf(request.getParameter("quantiaInicialInv")));
		
		Investimento inv = new Investimento(
				request.getParameter("agencia"),
				request.getParameter("numConta"),
				Float.valueOf(request.getParameter("saldo")),
				request.getParameter("tipo"),
				Float.valueOf(request.getParameter("resgateInv")),
				Float.valueOf(request.getParameter("quantiaInicialInv"))
//				Float.valueOf(request.getParameter("impostoResgateInv")),
//				Float.valueOf(request.getParameter("taxaRendimentoInv")),
//				Float.valueOf(request.getParameter("rendimentosInv"))
		);
		
		InvestimentoDao.incluir(inv);

//		ContaBancariaController cbController = new ContaBancariaController();
//		cbController.doGet(request, response);
		
		request.setAttribute("mensagem", inv.toString());

		request.setAttribute("titulo", "Contas de Investimentos");
		
		request.setAttribute("controller", "InvestimentoController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}
}
