package com.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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


	
 

	public void insertWithTransaction(Cliente cliente) throws SQLException, ClassNotFoundException{
		long lastIDStudent = 0;
		int result = 0;

		Connection dbConnection = null;
		java.sql.PreparedStatement preparedStatementInsertCliente = null;
		java.sql.PreparedStatement preparedStatementInsertTelefono = null;
		java.sql.PreparedStatement preparedStatementInsertEmail = null;
		java.sql.PreparedStatement preparedStatementInsertMascota = null;

		String queryCliente = "INSERT INTO `viajescolombia`.`clientes` "
				+ "(`nombre`, `primerApellido`, `segundoApellido`, `fechaEntrada`, `fechaSalida`, `sexo`, `idCT`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";	

		String 	qInsertTelefono = "INSERT INTO `viajescolombia`.`telefonos` (`numero`, `idtipo`, `idcliente`) VALUES (?, ?, ?)";


		String qInsertEmail = "INSERT INTO `viajescolombia`.`correos` (`correo`, `idcliente`) VALUES (?, ?)";


		String qInsertMascota = "INSERT INTO `viajescolombia`.`mascotas` (`descripcion`, `idcliente`) VALUES (?, ?)";

		
		try {
		dbConnection = getConexion();
		dbConnection.setAutoCommit(false);
		
		preparedStatementInsertCliente = dbConnection.prepareStatement(queryCliente,Statement.RETURN_GENERATED_KEYS);
		preparedStatementInsertCliente.setString(1, cliente.getNombre());
		preparedStatementInsertCliente.setString(2, cliente.getPrimerApellido());
		preparedStatementInsertCliente.setString(3, cliente.getSegundoApellido());
		java.sql.Date sqlEntrytDate = new java.sql.Date(cliente.getFechaEntrada().getTime());
		java.sql.Date sqlOurtDate = new java.sql.Date(cliente.getFechaSalida().getTime());
		preparedStatementInsertCliente.setDate(4, sqlEntrytDate);
		preparedStatementInsertCliente.setDate(5, sqlOurtDate);
		preparedStatementInsertCliente.setString(6, cliente.getSexo());
		ResultSet data = null;
		try {
			data = selectCT(cliente.getCentro());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(data.next()) {
			preparedStatementInsertCliente.setInt(7, data.getInt(1));
		}	
		
		result = preparedStatementInsertCliente.executeUpdate();
 		
		if(result>0) {
			//Recuperamos el ID insertado
			ResultSet key = preparedStatementInsertCliente.getGeneratedKeys();
			if(key.next()) {
				lastIDStudent =  key.getLong(1);  // Columna ID
			}
		}
		
		
		preparedStatementInsertTelefono = dbConnection.prepareStatement(qInsertTelefono);
		for(String phone : cliente.getTelefonos()) {
			preparedStatementInsertTelefono.setString(1,phone);
			preparedStatementInsertTelefono.setInt(2,1);
			preparedStatementInsertTelefono.setInt(3,(int)lastIDStudent);
			if(preparedStatementInsertTelefono.executeUpdate() > 0) {
				System.out.println(phone + "filas fueron afectadas TELEFONO");
			}

		}
 
		
		preparedStatementInsertEmail = dbConnection.prepareStatement(qInsertEmail);

		for(String email : cliente.getEmail()) {
			preparedStatementInsertEmail.setString(1,email);
			preparedStatementInsertEmail.setInt(2,(int) lastIDStudent);
			if(preparedStatementInsertEmail.executeUpdate() > 0) {
				System.out.println(email + "filas fueron afectadas EMAIL");
			}

		}

		preparedStatementInsertMascota = dbConnection.prepareStatement(qInsertMascota);

		for(String mascota : cliente.getMascotas()) {
			preparedStatementInsertMascota.setString(1,mascota);
			preparedStatementInsertMascota.setInt(2,(int)lastIDStudent);
			if(preparedStatementInsertMascota.executeUpdate() > 0) {
				System.out.println(mascota + "filas fueron afectadas MASCOTAS");
			}		

		}
		dbConnection.commit();

		System.out.println("Done!");
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			dbConnection.rollback();

		} finally {

			if (preparedStatementInsertCliente != null) {
				preparedStatementInsertCliente.close();
			}

			if (preparedStatementInsertEmail != null) {
				preparedStatementInsertEmail.close();
			}
			if (preparedStatementInsertTelefono != null) {
				preparedStatementInsertTelefono.close();
			}
			if (preparedStatementInsertMascota != null) {
				preparedStatementInsertMascota.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
		
	}


 


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

	public 	ResultSet selectCT(int idCT) throws ClassNotFoundException, SQLException {
		ResultSet data = null;
		String query= "";
		query = "SELECT nombre FROM centrosturisticos WHERE idCT = ? ";

		java.sql.PreparedStatement ptm;
		conn = getConexion();
		ptm =  conn.prepareStatement(query);
		ptm.setInt(1, idCT);
		data = ptm.executeQuery();
		return data;
	}
	
	public 	ResultSet selectCliente(int idcliente) throws ClassNotFoundException, SQLException {
		ResultSet data = null;
		String query= "";
		query = "SELECT * FROM clientes WHERE idcliente = ? ";

		java.sql.PreparedStatement ptm;
		conn = getConexion();
		ptm =  conn.prepareStatement(query);
		ptm.setInt(1, idcliente);
		data = ptm.executeQuery();
		return data;
	}

	public 	ResultSet selectCT(String nombre) throws ClassNotFoundException, SQLException {
		ResultSet data = null;
		String query= "";
		query = "SELECT idCT FROM centrosturisticos WHERE nombre = ? ";

		java.sql.PreparedStatement ptm;
		conn = getConexion();
		ptm =  conn.prepareStatement(query);
		ptm.setString(1, nombre);
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
	
	public 	ResultSet selectClientes(String nombreCT) throws SQLException{
		ResultSet data = null;
		String query= "";
		query = "SELECT * FROM viajescolombia.clientes INNER JOIN viajescolombia.centrosturisticos ON viajescolombia.centrosturisticos.idCT = viajescolombia.clientes.idCT AND viajescolombia.centrosturisticos.nombre = ?  ";
		java.sql.PreparedStatement ptmt;


		try {
			conn = getConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ptmt =  conn.prepareStatement(query);
		ptmt.setString(1, nombreCT);
		data = ptmt.executeQuery();
		return data;
	}


	public 	ResultSet selectCentros() throws SQLException{
		ResultSet data = null;
		String query= "";
		query = "SELECT * FROM centrosturisticos";
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


	public int deleteCliente(int idCliente) throws SQLException {
		int data =  0;
		String queryDelete = "DELETE FROM clientes WHERE clientes.idcliente = ?";
		java.sql.PreparedStatement ptmt;

		try {
			conn = getConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ptmt =  conn.prepareStatement(queryDelete);
		ptmt.setInt(1, idCliente);
		data = ptmt.executeUpdate();
		
		return data;
	}

	public int updateCliente(int idCliente, int idCT) throws SQLException {
		//Solo se puede cambiar el centro turistico
		int data =  0;
		String queryUpdate = "UPDATE `viajescolombia`.`clientes` SET `idCT` = ? WHERE (`idcliente` = ?)";
		java.sql.PreparedStatement ptmt;

		try {
			conn = getConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ptmt =  conn.prepareStatement(queryUpdate);
		ptmt.setInt(1, idCT);
		ptmt.setInt(2, idCliente);

		data = ptmt.executeUpdate();

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
