package com.modelo;

public class CentroTuristico {
	private int idCT;
	private String nombre;
	
	public CentroTuristico(int idCT, String nombre) {
		super();
		this.idCT = idCT;
		this.nombre = nombre;
	}

	public int getIdCT() {
		return idCT;
	}

	public void setIdCT(int idCT) {
		this.idCT = idCT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
