package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaBancariaDao;

public class ContaBancariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ContaBancariaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		if (request.getParameter("operacao") != null) {
//			request.getRequestDispatcher("contaBancariaCadastro.jsp").forward(request, response);
//		} else {
		
			request.setAttribute("contaBancariaLista.jsp", ContaBancariaDao.obterLista());

//			request.getRequestDispatcher("contaBancariaLista.jsp").forward(request, response);
//		}
		
		//MÉTODO EXCLUIR ESTÁ DANDO EXCEÇÃO
		
//		int id = Integer.valueOf(request.getParameter("id"));
//
//		ContaBancariaDao.excluir(id);
//
//		this.chamarListaContaBancaria(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String tipo = request.getParameter("tipo");
//
//		String agencia = request.getParameter("agencia");
//		String numConta = request.getParameter("numConta");
//		float saldo = Float.valueOf(request.getParameter("saldo"));
//
//		if ("CC".equals(tipo)) {
//			ContaCorrente cc = new ContaCorrente(agencia, numConta, saldo);
//
//			request.getSession().setAttribute("novaCC", cc);
//
//			request.getRequestDispatcher("contaCorrenteCadastro.jsp").forward(request, response);
//
//		} else if ("CP".equals(tipo)) {
//
//			ContaPoupanca cp = new ContaPoupanca(agencia, numConta, saldo);
//
//			request.getSession().setAttribute("novaCP", cp);
//
//			request.getRequestDispatcher("contaPoupancaCadastro.jsp").forward(request, response);
//
//		} else if ("INV".equals(tipo)) {
//
//			Investimento inv = new Investimento(agencia, numConta, saldo);
//
//			request.getSession().setAttribute("novoInv", inv);
//
//			request.getRequestDispatcher("investimentoCadastro.jsp").forward(request, response);
//		}
	}
}
