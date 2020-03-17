package com.juan.vigilanciaperroscaza.datos.roles;

import java.util.ArrayList;




import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolVeterinario")
	private List<Veterinarios> veterinarios = new ArrayList<Veterinarios>();
	
	public void addVeterinarios(Veterinarios veterinario) {

		if(!veterinarios.contains(veterinario)) {
			
			veterinarios.add(veterinario);
		}
	}	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolGuarda")
	private List<Guardas> guardas = new ArrayList<Guardas>();
	
	public void addGuardas(Guardas guarda) {

		if(!guardas.contains(guarda)) {
			
			guardas.add(guarda);
		}
	}	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolDuenho")
	private List<Duenho> duenhos = new ArrayList<Duenho>();
	
	public void addDuenho(Duenho duenho) {

		if(!duenhos.contains(duenho)) {
			
			duenhos.add(duenho);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Veterinarios> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<Veterinarios> veterinarios) {
		this.veterinarios = veterinarios;
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
	
	




	
	
}
