package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TitularDao;
import dao.UsuarioDao;
import negocio.Usuario;

public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AcessoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("invalido", false);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = UsuarioDao.validar(email, senha);

		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			request.setAttribute("titulares", TitularDao.obterLista());
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			request.setAttribute("invalido", true);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
