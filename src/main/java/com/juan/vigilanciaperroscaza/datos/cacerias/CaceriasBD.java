package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.guardas.GuardasBD;

@Entity

//Hay que hacer la unión con cazadores y guardas.

public class CaceriasBD {

	@Id
	private Long id_caceria;

	@Column
	@NotNull(message = "La provincia es obligatoria")
	private String provincia;

	@Column
	@NotNull(message = "La fecha es obligatoria")
	private String fecha;

	@Column
	@NotNull(message = "El numero de perros es obligatoria")
	@Min(1)
	private Integer numero_perros;

	@Column
	@NotNull(message = "El numero de perros es obligatoria")
	@Min(1)
	private Integer numero_cazadores;

	/*@ManyToMany(mappedBy = "cacerias",fetch=FetchType.EAGER)
	private List<DuenhoBD> listaDuenhos=new ArrayList<DuenhoBD>();
	
	public void addCacerias(DuenhoBD duenho) {
		if(!listaDuenhos.contains(duenho)) {
			listaDuenhos.add(duenho);
			
			List<CaceriasBD>listaCacerias=duenho.getCacerias();
			if(!listaCacerias.contains(this)) {
				listaCacerias.add(this);
			}
		}
	}*/

	@ManyToOne
	private GuardasBD guardas;

	public GuardasBD getGuardas() {
		return guardas;
	}

	public void setGuardas(GuardasBD guardas) {
		this.guardas = guardas;
	}

	

	/*public List<DuenhoBD> getListaDuenhos() {
		return listaDuenhos;
	}

	public void setListaDuenhos(List<DuenhoBD> listaDuenhos) {
		this.listaDuenhos = listaDuenhos;
	}*/

	

	

	public Integer getNumero_perros() {
		return numero_perros;
	}

	public void setNumero_perros(Integer numero_perros) {
		this.numero_perros = numero_perros;
	}

	public Integer getNumero_cazadores() {
		return numero_cazadores;
	}

	public void setNumero_cazadores(Integer numero_cazadores) {
		this.numero_cazadores = numero_cazadores;
	}

	public Long getId_caceria() {
		return id_caceria;
	}

	public void setId_caceria(Long id_caceria) {
		this.id_caceria = id_caceria;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Cacerias [id_caceria=" + id_caceria + ", provincia=" + provincia + ", fecha=" + fecha
				+ ", numero_perros=" + numero_perros + ", numero_cazadores=" + numero_cazadores  + ", guardas=" + guardas + "]";
	}
	
	

}
