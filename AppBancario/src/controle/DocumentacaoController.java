package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DocumentacaoDao;
import negocio.Documentacao;

public class DocumentacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	 private List<Documentacao> lista;

	public DocumentacaoController() {
		super();

//		 lista = new ArrayList<Documentacao>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("documentacoes", DocumentacaoDao.obterLista());
		request.getRequestDispatcher("documentacaoLista.jsp").forward(request, response);
	}

//		if (request.getParameter("operacao") != null) {
//
//			request.getRequestDispatcher("documentacaoCadastro.jsp").forward(request, response);
//		} else {
//			request.setAttribute("documentacoes", DocumentacaoDao.obterLista());
//
//			request.getRequestDispatcher("documentacaoLista.jsp").forward(request, response);
//		}
//
//		 this.chamarListaDoc(request, response);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String rg = request.getParameter("rg");
//		String cpf = request.getParameter("cpf");
//		String endereco = request.getParameter("endereco");
//		String cep = request.getParameter("cep");
//		String telefone = request.getParameter("telefone");

//		Documentacao doc = new Documentacao(rg, cpf, endereco, cep, telefone);
		
		Documentacao doc = new Documentacao(
				request.getParameter("rg"),
				request.getParameter("cpf"),
				request.getParameter("endereco"),
				request.getParameter("cep"),
				request.getParameter("telefone")
		);

		doc = DocumentacaoDao.incluir(doc);

//		if (doc != null) {
//			request.setAttribute("documentacoes", DocumentacaoDao.obterLista());
//
//			request.getRequestDispatcher("documentacaoLista.jsp").forward(request, response);
//		}
		
		request.setAttribute("mensagem", doc.toString());

		request.setAttribute("titulo", "Documentação");
		
		request.setAttribute("controller", "DocumentacaoController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}