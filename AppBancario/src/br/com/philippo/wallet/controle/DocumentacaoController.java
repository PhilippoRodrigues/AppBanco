package br.com.philippo.wallet.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.philippo.wallet.dao.DocumentacaoDao;
import br.com.philippo.wallet.negocio.Documentacao;

public class DocumentacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DocumentacaoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("tela") != null) {
			request.getRequestDispatcher("documentacaoCadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("lista", DocumentacaoDao.obterLista());
			request.getRequestDispatcher("documentacaoLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null) {

			DocumentacaoDao.excluir(Integer.valueOf(request.getParameter("id")));
			
			request.setAttribute("mensagem", "Titular deletado!");
			
		} else {
					String rg = request.getParameter("rg");
					String cpf = request.getParameter("cpf");
					String endereco = request.getParameter("endereco"); 
					String cep = request.getParameter("cep");
					String telefone = request.getParameter("telefone");

			Documentacao doc = new Documentacao(rg, cpf, endereco, cep, telefone);		
			
			DocumentacaoDao.incluir(doc);
			
			request.setAttribute("mensagem", doc.toString());
		}

			request.setAttribute("titulo", "Documentação");

			request.setAttribute("controller", "DocumentacaoController");

			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}
}