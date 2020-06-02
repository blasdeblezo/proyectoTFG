package com.juan.vigilanciaperroscaza.datos.revisiones;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;

@Entity
public class RevisionesBD {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRevision;
	
	@Column
	@NotNull(message="El diagnostico es obligatorio")
	private String diagnostico;
	
	@Column
	private int numeroRevisiones;
	
	@Column
	@NotNull(message="Nombre del perro es obligatorio")
	private String nombrePerro;
	
	@Column
	@NotNull(message="Fecha de la revision es obligatoria")
	private String fechaRevision;
	
	@Column
	@NotNull(message="Estado del perro es obligatorio")
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
