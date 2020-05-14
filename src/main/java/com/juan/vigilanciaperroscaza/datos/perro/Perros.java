package com.juan.vigilanciaperroscaza.datos.perro;

import javax.persistence.Column;
import javax.persistence.Id;

public class Perros {
	
	
	private Long id_perro;
	

	private String nombre;
	
	
	private String raza;
	
	
	private String fecha_nacimiento;
	
	
	private String fecha_muerte;
	
	
	private String revision;


	public Long getId_perro() {
		return id_perro;
	}


	public void setId_perro(Long id_perro) {
		this.id_perro = id_perro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getFecha_muerte() {
		return fecha_muerte;
	}


	public void setFecha_muerte(String fecha_muerte) {
		this.fecha_muerte = fecha_muerte;
	}


	public String getRevision() {
		return revision;
	}


	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	
	
	

}
