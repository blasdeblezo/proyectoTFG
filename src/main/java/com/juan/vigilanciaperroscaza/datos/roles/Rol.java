package com.juan.vigilanciaperroscaza.datos.roles;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.juan.vigilanciaperroscaza.datos.usuarios.Usuarios;






@Entity
public class Rol {

	@Id
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "rol")
	private List<Usuarios> usuarios = new ArrayList<Usuarios>();
	
	public void addDuenho(Usuarios usuario) {

		if(!usuarios.contains(usuario)) {
			
			usuarios.add(usuario);
		}
	}	
	
	

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
