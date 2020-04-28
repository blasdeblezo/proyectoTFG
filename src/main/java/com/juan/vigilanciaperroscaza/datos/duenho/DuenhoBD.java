package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.ArrayList;


import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.juan.vigilanciaperroscaza.datos.cacerias.CaceriasBD;
import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;



/*
 * Falta hacer las uniones con la tabla perros y cacerias.
 * */
@Entity

public class DuenhoBD implements UserDetails{

	@Id
	private String usuario;

	@Column
	private String dni;

	@Column
	private String nombre;

	@Column
	private String apellidos;

	@Column
	private String direccion;

	@Column
	private String provincia;

	@Column
	private String email;

	@Column
	private Integer telefono;

	@Column
	private String contrasenha;
	
	@Column
	private Integer numero_perros;
	
	@ManyToOne
	private Rol rolDuenho = new Rol();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CaceriasBD> cacerias = new ArrayList<CaceriasBD>();
	
	
	
	@OneToMany(mappedBy ="duenho", fetch=FetchType.EAGER)
	private List<PerrosBD>listaPerros=new ArrayList<PerrosBD>();

	
	

	public List<CaceriasBD> getCacerias() {
		return cacerias;
	}

	public void setCacerias(List<CaceriasBD> cacerias) {
		this.cacerias = cacerias;
	}

	public List<PerrosBD> getListaPerros() {
		return listaPerros;
	}

	public void setListaPerros(List<PerrosBD> listaPerros) {
		this.listaPerros = listaPerros;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	

	public Integer getNumero_perros() {
		return numero_perros;
	}

	public void setNumero_perros(Integer numero_perros) {
		this.numero_perros = numero_perros;
	}

	public Rol getRolDuenho() {
		return rolDuenho;
	}

	public void setRolDuenho(Rol rolDuenho) {
		this.rolDuenho = rolDuenho;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rolDuenho.getNombre()));
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		
		return this.contrasenha;
	}

	@Override
	public String getUsername() {
		
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	@Override
	public String toString() {
		return "Duenho [usuario=" + usuario + ", DNI=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dirección=" + direccion + ", provincia=" + provincia + ", email=" + email + ", telefono="
				+ telefono + ", contrasenha=" + contrasenha + ", numero_perros=" + numero_perros + ", rolDuenho="
				+ rolDuenho + "]";
	}

	

	
	
	



	

	

}
