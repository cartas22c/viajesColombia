package com.modelo;

public class TipoTelefono {
	
	private int idTipo;
	private Tipo tipo;
	
	enum Tipo{
		Fijo, Movil, Fax
	}

	public TipoTelefono(int idTipo, Tipo tipo) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	

}
