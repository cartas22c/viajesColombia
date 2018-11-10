package com.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

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
			return usuario;
		} else {
			return null;
		}
		
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    
}
