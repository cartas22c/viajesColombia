package com.modelo;

public class Telefono {
	
	private int idTelelfono;
	private String numero;
	private int idCliente;
	private int idTipo;
	
	public Telefono(int idTelelfono, String numero, int idCliente, int idTipo) {
		super();
		this.idTelelfono = idTelelfono;
		this.numero = numero;
		this.idCliente = idCliente;
		this.idTipo = idTipo;
	}

	public int getIdTelelfono() {
		return idTelelfono;
	}

	public void setIdTelelfono(int idTelelfono) {
		this.idTelelfono = idTelelfono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	
	
	

}
