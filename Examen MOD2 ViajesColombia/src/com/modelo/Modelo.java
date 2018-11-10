package com.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
    public Modelo() {
        // TODO Auto-generated constructor stub
    }
   
    
	public Modelo(Usuario usuario) {
		super();
		this.usuario = usuario;
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


	public List<Cliente> getClientes() throws ClassNotFoundException, SQLException {
		DBConexion myConexion = new DBConexion("scartas", "Temp2018$$");
		 ResultSet data = myConexion.selectClientes();
		
		if(data.next()) {
			clientes.add(new Cliente(data.getInt(1), data.getString(2), data.getString(3),
					data.getString(4), data.getDate(5), data.getDate(6), data.getString(7), data.getInt(8)));
 		} 
		return clientes;
 	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

    
}
