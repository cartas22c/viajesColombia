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
 * Servlet implementation class AJAXCentros
 */
@WebServlet("/AJAXCentros")
public class AJAXCentros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AJAXCentros() {
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
		//-----> Recuperamos de la peticion el dato enviado por AJAX en JSON.
		// -----> Instacimos un objeto PERSONA (java) con los datos del JSON.

		CentroTuristico c = myGson.fromJson(request.getParameter("jsondata"), CentroTuristico.class);
		Modelo m = new Modelo();
		try {
			List<Cliente> listadoClientes = m.getClientes(c.getNombre());
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
