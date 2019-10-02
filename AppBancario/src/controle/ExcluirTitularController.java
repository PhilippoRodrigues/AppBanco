package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TitularDao;

public class ExcluirTitularController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirTitularController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("titulares", TitularDao.obterLista());
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TitularDao.excluir(Integer.valueOf(request.getParameter("id")));

		request.setAttribute("mensagem", "Cadastro de titular cancelado");

		request.setAttribute("titulo", "Titular");

		request.setAttribute("controller", "ExcluirTitularController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}
}
