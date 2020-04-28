package com.juan.vigilanciaperroscaza.datos.roles;

import java.util.ArrayList;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.guardas.GuardasBD;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;



@Entity
public class Rol {

	@Id
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolVeterinario")
	private List<VeterinariosBD> veterinarios = new ArrayList<VeterinariosBD>();
	
	public void addVeterinarios(VeterinariosBD veterinario) {

		if(!veterinarios.contains(veterinario)) {
			
			veterinarios.add(veterinario);
		}
	}	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolGuarda")
	private List<GuardasBD> guardas = new ArrayList<GuardasBD>();
	
	public void addGuardas(GuardasBD guarda) {

		if(!guardas.contains(guarda)) {
			
			guardas.add(guarda);
		}
	}	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolDuenho")
	private List<DuenhoBD> duenhos = new ArrayList<DuenhoBD>();
	
	public void addDuenho(DuenhoBD duenho) {

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

	public List<VeterinariosBD> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<VeterinariosBD> veterinarios) {
		this.veterinarios = veterinarios;
	}

	public List<GuardasBD> getGuardas() {
		return guardas;
	}

	public void setGuardas(List<GuardasBD> guardas) {
		this.guardas = guardas;
	}

	public List<DuenhoBD> getDuenhos() {
		return duenhos;
	}

	public void setDuenhos(List<DuenhoBD> duenhos) {
		this.duenhos = duenhos;
	}	
	
	




	
	
}
