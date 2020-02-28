package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.cacerias.Cacerias;
import com.juan.vigilanciaperroscaza.datos.perro.Perros;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.usuarios.Usuarios;


/*
 * Falta hacer las uniones con la tabla perros y cacerias.
 * */
@Entity
public class Duenho{

	@Id
	private String id_duenho;

	@OneToOne
	private Usuarios usuarios;
	
	@OneToMany(mappedBy ="duenho", cascade = CascadeType.ALL)
	private List<Perros>listaPerros=new ArrayList<Perros>();
	
	@ManyToMany(mappedBy = "duenhos",cascade = CascadeType.ALL)
	private List<Cacerias> listaCecerias=new ArrayList<Cacerias>();
	
	public void addCacerias(Cacerias caceria) {
		if(!listaCecerias.contains(caceria)) {
			listaCecerias.add(caceria);
			
			List<Duenho>listaDuenhos=caceria.getDuenhos();
			if(!listaDuenhos.contains(this)) {
				listaDuenhos.add(this);
			}
		}
	}

	private void addPerros(Perros perro) {
		if(!listaPerros.contains(perro)) {
			listaPerros.add(perro);
			perro.setDuenho(this);
		}
	}
	


	public String getId_duenho() {
		return id_duenho;
	}

	public void setId_duenho(String id_duenho) {
		this.id_duenho = id_duenho;
	}

	public List<Perros> getListaPerros() {
		return listaPerros;
	}

	public void setListaPerros(List<Perros> listaPerros) {
		this.listaPerros = listaPerros;
	}

	public List<Cacerias> getListaCecerias() {
		return listaCecerias;
	}

	public void setListaCecerias(List<Cacerias> listaCecerias) {
		this.listaCecerias = listaCecerias;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	

}
