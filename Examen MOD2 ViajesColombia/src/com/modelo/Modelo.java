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


	
	public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {
		ResultSet data;
		DBConexion dbConexion = new DBConexion("scartas", "Temp2018$$");
		data = dbConexion.selectEstudiantes();
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
	
	
	

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	


	public void setCt(CentroTuristico ct) {
		this.ct = ct;
	}
	
	

    
}
