package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DocumentacaoDao;
import dao.TitularDao;
import negocio.Documentacao;
import negocio.Titular;

public class DocumentacaoTitularController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Titular titular;

	public DocumentacaoTitularController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		titular = TitularDao.obterPorId(Integer.valueOf(request.getParameter("id")));

		request.setAttribute("titular", titular);
		request.setAttribute("documentacoes", DocumentacaoDao.obterLista());

		request.getRequestDispatcher("documentacaoTitular.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		titular.setDocumentacao(new Documentacao(Integer.valueOf(request.getParameter("idDocumentacao"))));

		TitularDao.associarDocumentacao(titular);

		request.setAttribute("titulares", TitularDao.obterLista());
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}
}
