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
import com.modelo.Cliente;
import com.modelo.Modelo;
import com.sun.org.apache.xml.internal.serialize.Printer;

import sun.print.PrinterJobWrapper;

/**
 * Servlet implementation class AJAXManager
 */

/**
 * Para el codigo del Servlet con AJAX ---> https://www.w3schools.com/js/js_json_php.asp    [PHP file]
 * */


@WebServlet("/AJAXManager")
public class AJAXManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AJAXManager() {
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
		//doGet(request, response);

		/**
		 * Montamos la respuesta para la peticion AJAX*/
		// Establecemos o 'avisamos' el tipo de dato que vamos a enviar. JSON. -> Esto sera renderizado por JavaScript
		response.setContentType("\"Content-Type: application/json; charset=UTF-8\"");
		// Java no entiende JSON, es necesario una biblioteca externa. GSON   -------->>> Importala!!!
		// ----------->>   JSON -> GSON -> .class
		Gson myGson = new Gson();
		//-----> Recuperamos de la peticion el dato enviado por AJAX en JSON.
		// -----> Instacimos un objeto PERSONA (java) con los datos del JSON.

		Cliente p = myGson.fromJson(request.getParameter("jsondata"), Cliente.class);
		Modelo m = new Modelo();
		// Insertamos la persona
		try {
			m.setCliente(p);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
