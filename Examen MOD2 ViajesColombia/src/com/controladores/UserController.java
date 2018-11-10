package com.controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.Modelo;
import com.modelo.Usuario;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		
		String usuario = request.getParameter("user");
		String password = request.getParameter("pwd");
		
		Modelo m = new Modelo(new Usuario(usuario, password));

		try {
			if(m.getUsuario() != null) {
				// El usuario EXISTE en BBDD
				System.out.println("El usuario existe!");
				
				// Metemos el usuario en Sesion!
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", m.getUsuario());
				// Envio al controlador Principal para validar el nivel de user
				RequestDispatcher view = request.getRequestDispatcher("prueba.html");
				view.forward(request, response);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher("index.html");
				view.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
