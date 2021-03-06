package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.revisiones.RevisionesBD;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;

/*
 * Hay que cambiar, si se puede, el tipo de las fechas de String a date.
 * Falta hacer la unión con la tabla de dueño
 * */
@Entity
public class PerrosBD {

	@Id
	@NotNull(message="id obligatorio")
	private String id_perro;
	
	@Column
	@NotNull(message = "Nombre obligatorio")
	private String nombre;
	
	@Column
	@NotNull(message = "Raza obligatoria")
	private String raza;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Fecha obligatoria")
	private String fecha_nacimiento;
	
	@Column
	private String fecha_muerte;
	
	@Column
	private String revision;
	
	@ManyToOne
	@NotNull(message = "Dueño obligatorio")
	private DuenhoBD duenho;
	
	@ManyToOne
	private VeterinariosBD veterinarios;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "perros")
	private List<RevisionesBD> revisiones=new ArrayList<RevisionesBD>();
	
	public void addRevisiones(RevisionesBD revision) {
		if(!revisiones.contains(revision)) {
			revisiones.add(revision);
		}
	}
	



	public List<RevisionesBD> getRevisiones() {
		return revisiones;
	}




	public void setRevisiones(List<RevisionesBD> revisiones) {
		this.revisiones = revisiones;
	}




	public VeterinariosBD getVeterinarios() {
		return veterinarios;
	}




	public void setVeterinarios(VeterinariosBD veterinarios) {
		this.veterinarios = veterinarios;
	}




	public DuenhoBD getDuenho() {
		return duenho;
	}

	public void setDuenho(DuenhoBD duenho) {
		this.duenho = duenho;
	}

	

	public String getId_perro() {
		return id_perro;
	}

	public void setId_perro(String id_perro) {
		this.id_perro = id_perro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFecha_muerte() {
		return fecha_muerte;
	}

	public void setFecha_muerte(String fecha_muerte) {
		this.fecha_muerte = fecha_muerte;
	}
	
	

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}


	/*public List<RevisionesBD> getRevisiones() {
		return revisiones;
	}


	public void setRevisiones(List<RevisionesBD> revisiones) {
		this.revisiones = revisiones;
	}*/


	@Override
	public String toString() {
		return "PerrosBD [id_perro=" + id_perro + ", nombre=" + nombre + ", raza=" + raza + ", fecha_nacimiento="
				+ fecha_nacimiento + ", fecha_muerte=" + fecha_muerte + ", revision=" + revision + ", duenho=" + duenho
				+ ", veterinarios=" + veterinarios + ", revisiones="  + "]";
	}

	

	
	
	
}
