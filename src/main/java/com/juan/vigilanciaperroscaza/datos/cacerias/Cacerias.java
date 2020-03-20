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
	private Long Id_caceria;

	@Column
	private String provincia;

	@Column
	private String fecha;

	@Column
	private int numero_perros;

	@Column
	private int numero_cazadores;

	/*@ManyToMany(mappedBy = "cacerias",fetch=FetchType.EAGER)
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
	}*/

	public int getNumero_perros() {
		return numero_perros;
	}

	public void setNumero_perros(int numero_perros) {
		this.numero_perros = numero_perros;
	}

	public int getNumero_cazadores() {
		return numero_cazadores;
	}

	public void setNumero_cazadores(int numero_cazadores) {
		this.numero_cazadores = numero_cazadores;
	}

	public Long getId_caceria() {
		return Id_caceria;
	}

	public void setId_caceria(Long id_caceria) {
		Id_caceria = id_caceria;
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

}
