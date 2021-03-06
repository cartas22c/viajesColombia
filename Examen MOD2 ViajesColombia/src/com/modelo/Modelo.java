package com.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Modelo
 */
@Stateless
@LocalBean
public class Modelo {

	/**
	 * Default constructor. 
	 */
	private Usuario usuario;
	private List<Cliente> clientes ;
	private CentroTuristico ct;
	private List<CentroTuristico> centros;
	private Cliente cliente;
	private Cliente clienteUpdate;
	private Cliente clienteDelete;

	
	public Modelo() {
		// TODO Auto-generated constructor stub
	}


	public Usuario getUsuario() throws ClassNotFoundException, SQLException {
		DBConexion myConexion = new DBConexion("scartas", "Temp2018$$");
		ResultSet data = null;
		data = myConexion.selectUsuario(usuario.getLogin(), usuario.getPassword());
		if(data.next()) {
			Usuario user = new Usuario(
					data.getInt(1), data.getString(2), data.getString(3), data.getInt(4));
			return user;
		} else {
			return null;
		}

	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {
		ResultSet data;
		DBConexion dbConexion = new DBConexion("scartas", "Temp2018$$");
		data = dbConexion.selectClientes();
		clientes  = new ArrayList<>();
		while(data.next()) {
			ResultSet ctaux = dbConexion.selectCT(data.getInt(8));
			String nombreCT = "";
			while(ctaux.next()) {
				nombreCT = ctaux.getString(1);
			}
			clientes.add(new Cliente(data.getInt(1),
					data.getString(2), data.getString(3), 
					data.getString(4), data.getDate(5), 
					data.getDate(6), data.getString(7),nombreCT));
		}
		return clientes;
	}

	public List<Cliente> getClientes(String nombreCT) throws SQLException, ClassNotFoundException {
		ResultSet data;
		DBConexion dbConexion = new DBConexion("scartas", "Temp2018$$");
		data = dbConexion.selectClientes(nombreCT);
		clientes  = new ArrayList<>();
		while(data.next()) {
			clientes.add(new Cliente(data.getInt(1),
					data.getString(2), data.getString(3), 
					data.getString(4), data.getDate(5), 
					data.getDate(6), data.getString(7),nombreCT));
		}
		return clientes;
	}




	public List<CentroTuristico> getCentros() throws SQLException {

		ResultSet data;
		DBConexion dbConexion = new DBConexion("scartas", "Temp2018$$");
		data = dbConexion.selectCentros();
		centros  = new ArrayList<>();
		while(data.next()) {
			int id = data.getInt(1);
			String nombre = data.getString(2);
			centros.add(new CentroTuristico(id,nombre));
		}

		return centros;
	}



	public void setCentros(List<CentroTuristico> centros) {
		this.centros = centros;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}





	public void setCt(CentroTuristico ct) {
		this.ct = ct;
	}


	public Cliente getCliente(int idCliente) throws SQLException, ClassNotFoundException {
		DBConexion myDB = new DBConexion("scartas", "Temp2018$$");
		ResultSet data = myDB.selectCliente(idCliente);
		while(data.next()) {
			return cliente;
		}
		return null;
	}


	public void setCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
		DBConexion myDB = new DBConexion("scartas", "Temp2018$$");
		myDB.insertWithTransaction(cliente);
	}


	public Cliente getClienteUpdate() {
		return clienteUpdate;
	}


	public void setClienteUpdate(Cliente clienteUpdate, int idCT) throws SQLException {
		DBConexion myDB = new DBConexion("scartas", "Temp2018$$");
		myDB.updateCliente(clienteUpdate.getIdCliente(), idCT);
		this.clienteUpdate = clienteUpdate;
	}


	public Cliente getClienteDelete() {
		return clienteDelete;
	}


	public void setClienteDelete(Cliente clienteDelete) throws SQLException {
		DBConexion myDB = new DBConexion("scartas", "Temp2018$$");
		myDB.deleteCliente(clienteDelete.getIdCliente());
		this.clienteDelete = clienteDelete;
	}




}
