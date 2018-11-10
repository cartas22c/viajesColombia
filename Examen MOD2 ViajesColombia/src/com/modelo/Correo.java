package com.modelo;

public class Correo {

	private int idCorreo;
	private String correo;
	private int idCliente;
	
	public Correo(int idCorreo, String correo, int idCliente) {
		super();
		this.idCorreo = idCorreo;
		this.correo = correo;
		this.idCliente = idCliente;
	}

	public int getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
	
}
