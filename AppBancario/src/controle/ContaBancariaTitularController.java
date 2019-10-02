package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaBancariaDao;
import dao.TitularDao;
import negocio.Titular;

public class ContaBancariaTitularController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Titular titular;

	public ContaBancariaTitularController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		titular = TitularDao.obterPorId(Integer.valueOf(request.getParameter("id")));

		request.setAttribute("titular", titular);
		request.setAttribute("tiposConta", ContaBancariaDao.obterLista());
		
		request.getRequestDispatcher("associaContaBancaria.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		for (String idContaBancaria : request.getParameterValues("tiposConta")) {
			TitularDao.realizarCadastroConta(titular.getId(), Integer.valueOf(idContaBancaria));
		}

		request.setAttribute("titulares", TitularDao.obterLista());
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}
}
