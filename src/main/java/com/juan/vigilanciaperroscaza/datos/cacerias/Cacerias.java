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

import com.juan.vigilanciaperroscaza.datos.duenho.Duenho;
import com.juan.vigilanciaperroscaza.datos.guardas.Guardas;

@Entity

//Hay que hacer la unión con cazadores y guardas.

public class Cacerias {

	@Id
	private Long id_caceria;

	@Column
	private String provincia;

	@Column
	private String fecha;

	@Column
	private Integer numero_perros;

	@Column
	private Integer numero_cazadores;

	@ManyToMany(mappedBy = "cacerias",fetch=FetchType.EAGER)
	private List<Duenho> listaDuenhos=new ArrayList<Duenho>();
	
	public void addCacerias(Duenho duenho) {
		if(!listaDuenhos.contains(duenho)) {
			listaDuenhos.add(duenho);
			
			List<Cacerias>listaCacerias=duenho.getCacerias();
			if(!listaCacerias.contains(this)) {
				listaCacerias.add(this);
			}
		}
	}

	@ManyToOne
	private Guardas guardas;

	public Guardas getGuardas() {
		return guardas;
	}

	public void setGuardas(Guardas guardas) {
		this.guardas = guardas;
	}

	

	public List<Duenho> getListaDuenhos() {
		return listaDuenhos;
	}

	public void setListaDuenhos(List<Duenho> listaDuenhos) {
		this.listaDuenhos = listaDuenhos;
	}

	

	

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
				+ ", numero_perros=" + numero_perros + ", numero_cazadores=" + numero_cazadores + ", listaDuenhos="
				+ listaDuenhos + ", guardas=" + guardas + "]";
	}
	
	

}
