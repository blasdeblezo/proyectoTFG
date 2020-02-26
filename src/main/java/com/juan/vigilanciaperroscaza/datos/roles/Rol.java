package com.juan.vigilanciaperroscaza.datos.roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.juan.vigilanciaperroscaza.datos.duenho.Duenho;
import com.juan.vigilanciaperroscaza.datos.guardas.Guardas;
import com.juan.vigilanciaperroscaza.datos.veterinarios.Veterinarios;




@Entity
public class Rol {

	@Id
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "rol")
	private List<Duenho> duenhos = new ArrayList<Duenho>();
	
	public void addDuenho(Duenho duenho) {

		if(!duenhos.contains(duenho)) {
			
			duenhos.add(duenho);
		}
	}	
	

	@OneToMany(mappedBy = "rolguarda")
	private List<Guardas> guardas = new ArrayList<Guardas>();
	
	public void addGuardas(Guardas guarda) {

		if(!guardas.contains(guarda)) {
			
			guardas.add(guarda);
		}
	}	

	@OneToMany(mappedBy = "rolveterinarios")
	private List<Veterinarios> veterinarios = new ArrayList<Veterinarios>();
	
	public void addveterinarios(Veterinarios veterinario) {

		if(!veterinarios.contains(veterinario)) {
			
			veterinarios.add(veterinario);
		}
	}	

	public List<Guardas> getGuardas() {
		return guardas;
	}


	public void setGuardas(List<Guardas> guardas) {
		this.guardas = guardas;
	}


	public List<Duenho> getDuenhos() {
		return duenhos;
	}


	public void setDuenhos(List<Duenho> duenhos) {
		this.duenhos = duenhos;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
