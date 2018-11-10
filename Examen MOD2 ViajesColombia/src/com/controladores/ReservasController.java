package com.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.Usuario;

/**
 * Servlet implementation class ReservasController
 */
@WebServlet("/ReservasController")
public class ReservasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//Controlamos los permisos del usuario
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		Usuario currentUser = (Usuario)session.getAttribute("currentUser");

		// Si es ESTANDAR
		if(currentUser.getNivel() == 1) {
			request.getRequestDispatcher("/listadoReservas.jsp").forward(request, response);

		}
		// Si es ADMINISTRADOR
		else {
			request.getRequestDispatcher("/adminReservas.jsp").forward(request, response);

		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


	}

}
