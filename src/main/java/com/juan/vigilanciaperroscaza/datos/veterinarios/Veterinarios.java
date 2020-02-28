package com.juan.vigilanciaperroscaza.datos.veterinarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.perro.Perros;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.usuarios.Usuarios;
// Unir con la tabla perros
@Entity
public class Veterinarios{

	@Id
	private String id_veterinario;
	
	@OneToOne
	private Usuarios usuarios;
	
	@ManyToMany(mappedBy = "veterinarios",cascade = CascadeType.ALL )
	private List<Perros>lisPerros=new ArrayList<Perros>();
	
	public void addPerros(Perros perro) {
		if(!lisPerros.contains(perro)) {
			lisPerros.add(perro);
			
			List<Veterinarios>lisVeterinarios=perro.getVeterinarios();
			if(!lisVeterinarios.contains(this)) {
				lisVeterinarios.add(this);
			}
		}
	}

	public String getId_veterinario() {
		return id_veterinario;
	}

	public void setId_veterinario(String id_veterinario) {
		this.id_veterinario = id_veterinario;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public List<Perros> getLisPerros() {
		return lisPerros;
	}

	public void setLisPerros(List<Perros> lisPerros) {
		this.lisPerros = lisPerros;
	}

	
	
	
	
}
