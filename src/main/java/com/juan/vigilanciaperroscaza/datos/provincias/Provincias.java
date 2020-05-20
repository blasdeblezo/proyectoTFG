package com.juan.vigilanciaperroscaza.datos.provincias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Provincias {
	
	@Id
	private int idprovincia;
	
	@Column
	private String nombre;
	
	

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Provincias [idprovincia=" + idprovincia + ", nombre=" + nombre + "]";
	}
	
	

}
