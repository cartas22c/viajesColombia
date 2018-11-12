package com.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.modelo.CentroTuristico;
import com.modelo.Cliente;
import com.modelo.Modelo;

/**
 * Servlet implementation class AJAXUpdateDelete
 */
@WebServlet("/AJAXUpdateDelete")
public class AJAXUpdateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AJAXUpdateDelete() {
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
 		response.setContentType("\"Content-Type: application/json; charset=UTF-8\"");
		Gson myGson = new Gson();

		Modelo m = new Modelo();

		String action = request.getParameter("action");
		String idCliente = request.getParameter("idcliente");
		String idCT = request.getParameter("idct");

		 if(action.contains("delete")) {
			try {
				System.out.println("Pasoooo por aquiiiiii");
				m.setClienteDelete(new Cliente(Integer.parseInt(idCliente)));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}

		
		// Recuperamos el listado de Personas para renderizarlo despues en la tabla Registros.
			try {
				List<Cliente> listadoClientes = m.getClientes();
				PrintWriter out = response.getWriter();
				out.print(myGson.toJson(listadoClientes));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}




}
