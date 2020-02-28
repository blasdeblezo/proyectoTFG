package com.juan.vigilanciaperroscaza.datos.guardas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.cacerias.Cacerias;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.usuarios.Usuarios;

//Unir con la tabla de cacerias. Añadir en el proyecto el atributo Email y en los requisitos. 
@Entity
public class Guardas {

	@Id
	private String id_guarda;

	@OneToOne
	private Usuarios usuarios;
	
	@OneToMany(mappedBy = "guardas",cascade = CascadeType.ALL)
	private List<Cacerias>lisCacerias=new ArrayList<Cacerias>();
	
	

	public List<Cacerias> getLisCacerias() {
		return lisCacerias;
	}

	public void setLisCacerias(List<Cacerias> lisCacerias) {
		this.lisCacerias = lisCacerias;
	}

	public String getId_guarda() {
		return id_guarda;
	}

	public void setId_guarda(String id_guarda) {
		this.id_guarda = id_guarda;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
	


}
