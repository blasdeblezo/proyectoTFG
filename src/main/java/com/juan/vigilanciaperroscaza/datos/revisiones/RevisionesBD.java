package com.juan.vigilanciaperroscaza.datos.revisiones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;

@Entity
public class RevisionesBD {
	
	@Id
	@Column
	private Long idRevision;
	
	@Column
	private String diagnostico;
	
	@Column
	private int numeroRevisiones;
	
	@Column
	private String nombrePerro;
	
	@Column
	private String fechaRevision;
	
	@Column
	private String estado;
	
	@ManyToOne
	private PerrosBD perros=new PerrosBD();

	public Long getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(Long idRevision) {
		this.idRevision = idRevision;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public int getNumeroRevisiones() {
		return numeroRevisiones;
	}

	public void setNumeroRevisiones(int numeroRevisiones) {
		this.numeroRevisiones = numeroRevisiones;
	}

	public String getNombrePerro() {
		return nombrePerro;
	}

	public void setNombrePerro(String nombrePerro) {
		this.nombrePerro = nombrePerro;
	}

	public String getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public PerrosBD getPerros() {
		return perros;
	}

	public void setPerros(PerrosBD perros) {
		this.perros = perros;
	}
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "RevisionesBD [idRevision=" + idRevision + ", diagnostico=" + diagnostico + ", numeroRevisiones="
				+ numeroRevisiones + ", nombrePerro=" + nombrePerro + ", fechaRevision=" + fechaRevision + ", estado="
				+ estado + ", perros=" + perros + "]";
	}


	
	
}
