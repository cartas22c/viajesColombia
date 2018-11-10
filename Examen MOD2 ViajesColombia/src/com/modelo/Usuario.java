package com.modelo;

public class Usuario {
	
	private int idUsuario;
	private String login;
	private String password;
	private Nivel nivel;
	
	enum Nivel{
		Estandar, Administrador
	}

	public Usuario(int idUsuario, String login, String password, Nivel nivel) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.password = password;
		this.nivel = nivel;
	}
	
	public Usuario(String login, String password) {
		super();
		
		this.login = login;
		this.password = password;
		
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	 
	
	
	
}
