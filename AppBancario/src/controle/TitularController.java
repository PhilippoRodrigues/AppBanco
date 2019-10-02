package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TitularDao;
import negocio.Titular;

public class TitularController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TitularController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("titularCadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("titulares", TitularDao.obterLista());
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("idTitular") != null) {

		} else {
			Titular titular = new Titular(
					request.getParameter("nome"), 
					request.getParameter("nomeBanco"), 
					request.getParameter("dataAberturaConta"));

			titular = TitularDao.incluir(titular);
			
			request.setAttribute("mensagem", titular.toString());
			request.setAttribute("titulo", "Titular");
			request.setAttribute("controller", "TitularController");
			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		}
	}
}
