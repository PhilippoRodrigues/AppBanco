package br.com.philippo.wallet.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.philippo.wallet.dao.ContaBancariaDao;

public class ContaBancariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ContaBancariaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setAttribute("contaBancariaLista.jsp", ContaBancariaDao.obterLista());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
