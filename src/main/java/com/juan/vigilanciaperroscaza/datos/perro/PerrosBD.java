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
	private String id_perro;
	
	@Column
	private String nombre;
	
	@Column
	private String raza;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fecha_nacimiento;
	
	@Column
	private String fecha_muerte;
	
	@Column
	private String revision;
	
	@ManyToOne
	private DuenhoBD duenho;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<VeterinariosBD> veterinarios=new ArrayList<VeterinariosBD>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "perros")
	private List<RevisionesBD> revisiones=new ArrayList<RevisionesBD>();
	
	public void addRevisiones(RevisionesBD revision) {
		if(!revisiones.contains(revision)) {
			revisiones.add(revision);
		}
	}
	

	public List<VeterinariosBD> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<VeterinariosBD> veterinarios) {
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

	@Override
	public String toString() {
		return "Perros [id_perro=" + id_perro + ", nombre=" + nombre + ", raza=" + raza + ", fecha_nacimiento="
				+ fecha_nacimiento + ", fecha_muerte=" + fecha_muerte + ", revision=" + revision + ", duenho=" + duenho
				+ ", veterinarios=" + veterinarios + "]";
	}

	
	
	
}
