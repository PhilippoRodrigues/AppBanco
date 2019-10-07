package br.com.philippo.wallet.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.philippo.wallet.dao.TitularDao;
import br.com.philippo.wallet.negocio.Titular;

public class ConsultaTitularController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Titular titular;

	public ConsultaTitularController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		titular = TitularDao.obterPorId(Integer.valueOf(request.getParameter("id")));

		request.setAttribute("titular", titular);

		request.getRequestDispatcher("titularConsulta.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
