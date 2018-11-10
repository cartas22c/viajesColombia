package com.modelo;

public class Mascota {

	private int idMascota;
	private String descripcion;
	private int idCliente;
	
	public Mascota(int idMascota, String descripcion, int idCliente) {
		super();
		this.idMascota = idMascota;
		this.descripcion = descripcion;
		this.idCliente = idCliente;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
	
}
