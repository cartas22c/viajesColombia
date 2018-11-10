package com.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.fastinfoset.sax.Properties;

/*Conexion a la base de datos MySQL mediante el adaptador JDBC*/

public class DBConexion {

	private String 		user;
	private String 		pwd;
	private Connection  conn;

	public DBConexion(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}

	// Metodo que devuelve una conexion con la bbdd o esquema especificado.

	public Connection getConexion() throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/viajescolombia",this.user, this.pwd);
			System.out.println("Conectado a la BBDD viajescolombia!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	
	// INSERT PERSONA
	
/*	public void insertPersona(Persona p) throws SQLException {
		int result = 0;
		String query = "";
		query = "INSERT INTO `actividad11`.`personas` (`nombre`, `apellidos`, `edad`) VALUES (?, ?, ?)";
		java.sql.PreparedStatement ptmt;
		
		try {
			conn = getConexion();
			try {
				// ----> Comienza la TRANSACCION
				conn.setAutoCommit(false);
				ptmt =  conn.prepareStatement(query);
				
				ptmt.setString(1, p.getNombre());
				ptmt.setString(2, p.getApellidos());
				ptmt.setInt(3, p.getEdad());
				
				result = ptmt.executeUpdate();
				System.out.println(result +" " + "filas fueron afectadas");
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				conn.rollback();
				e.printStackTrace();
			} finally {
				conn.setAutoCommit(true);
			}		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	///////////// ----> Fin del INSERT
	
	
	
	
	public 	ResultSet selectUsuario(String usuario, String password) throws ClassNotFoundException, SQLException {
		ResultSet data = null;
		String query= "";
		query = "SELECT * FROM usuarios WHERE login = ? AND password = ? ";
		
		java.sql.PreparedStatement ptm;
		conn = getConexion();
		ptm =  conn.prepareStatement(query);
		ptm.setString(1, usuario);
		ptm.setString(2, password);
		data = ptm.executeQuery();
		return data;
	}
	
	
	public 	ResultSet selectClientes() throws SQLException{
		ResultSet data = null;
		String query= "";
		query = "SELECT * FROM viajescolombia.clientes";
		java.sql.Statement stmt;
		
		
		try {
			conn = getConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt =  conn.createStatement();
		data = stmt.executeQuery(query);
		return data;
	}
	
	// Metodo inserta un nuevo estudiante.
	//// pre: el telefono se encuentra en una tabla diferente -> MARCO TRANSACCION {ATOMICO}
	/*public void insertNewStudent(Estudiante e) throws SQLException {
		// 1- Crear registro en la tabla ESTUDIANTE.
		/// pre: el ID es un incremental!!
		long lastIDStudent = 0;
		int result = 0;
		String qInsertStudent= "";
		qInsertStudent="INSERT INTO `academia`.`estudiantes` (`nombre`, `primer apellido`, `segundo apellido`,"
				+ "`fecha de alta`, `total de asignaturas`, `documento de identidad`) VALUES (?, ?, ?, ?, ? , ?)";
		*//**Los parametros no se pillan tal cual del metodo si no que se asignan en la siguiente linea de codigo
		 * *//*
		String qInsertTelefono= "";
		qInsertTelefono = "INSERT INTO `academia`.`telefonos` (`idEstudiante`, `numero`, `idTipo`) VALUES (?, ?, ?)";

		java.sql.PreparedStatement ptmt;
		java.sql.PreparedStatement ptmtphone;


		try {
			conn = getConexion();
			// ---> Comienza la TRANSACCION!
			try {
				conn.setAutoCommit(false);
				//--> Recuperamos el ID que se insertara en Estudiantes para usarlo posteriormente
				ptmt =  conn.prepareStatement(qInsertStudent,Statement.RETURN_GENERATED_KEYS);

				ptmt.setString(1, e.getNombre());
				ptmt.setString(2, e.getApellido1());
				ptmt.setString(3, e.getApellido2());
				ptmt.setDate(4, Date.valueOf(e.getFechaAlta()));
				ptmt.setInt(5, e.getTotalAsignaturas());
				ptmt.setString(6, e.getDni());

				// Si no machacamos la query montada
				result = ptmt.executeUpdate();
				System.out.println(result + "filas fueron afectadas");
				if(result>0) {
					//Recuperamos el ID insertado
					ResultSet key = ptmt.getGeneratedKeys();
					if(key.next()) {
						lastIDStudent =  key.getLong(1);  // Columna ID
					}
				}
				
				
				ptmtphone =  conn.prepareStatement(qInsertTelefono);
				for(String phone : e.getTelefonos()) {
					ptmtphone.setInt(1,(int)lastIDStudent);
					ptmtphone.setString(2,phone);
					ptmtphone.setInt(3,1);
					result = ptmtphone.executeUpdate();
					System.out.println(result + "filas fueron afectadas");

					// Insert en la tabla TELEFONO

				} // fin for
				//----------------------> Commiteamos cambios!
				conn.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				conn.rollback();
			} finally { // Se ejecutara si o si antes de que el programa salte fuera de su ejecuccion
				conn.setAutoCommit(true);
			}


		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}

	} // Fin insert!
	
	
	public 	ResultSet selectEstudiantes() throws SQLException{
		ResultSet data = null;
		String query= "";
		query = "SELECT * FROM academia.estudiantes";
		java.sql.Statement stmt;
		
		
		try {
			conn = getConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt =  conn.createStatement();
		data = stmt.executeQuery(query);
		return data;
	}*/






}
