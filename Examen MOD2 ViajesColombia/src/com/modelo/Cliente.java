package com.modelo;

import java.util.Date;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Sexo sexo;
	private int idCT;
	
	enum Sexo{
		Hombre, Mujer
	}

	public Cliente(int idCliente, String nombre, String primerApellido, String segundoApellido, Date fechaEntrada,
			Date fechaSalida, Sexo sexo, int idCT) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.sexo = sexo;
		this.idCT = idCT;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getIdCT() {
		return idCT;
	}

	public void setIdCT(int idCT) {
		this.idCT = idCT;
	}

 
}
