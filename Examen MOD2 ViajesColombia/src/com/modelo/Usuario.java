package com.modelo;

public class Usuario {
	
	private int idUsuario;
	private String login;
	private String password;
	private int nivel;
	
	public Usuario(int idUsuario, String login, String password, int nivel) {
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
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	
	
	
	
}