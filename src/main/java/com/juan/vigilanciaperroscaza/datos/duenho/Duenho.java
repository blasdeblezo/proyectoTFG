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

import com.juan.vigilanciaperroscaza.datos.cacerias.Cacerias;
import com.juan.vigilanciaperroscaza.datos.perro.Perros;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;



/*
 * Falta hacer las uniones con la tabla perros y cacerias.
 * */
@Entity

public class Duenho implements UserDetails{

	@Id
	private String usuario;

	@Column
	private String DNI;

	@Column
	private String nombre;

	@Column
	private String apellidos;

	@Column
	private String dirección;

	@Column
	private String provincia;

	@Column
	private String email;

	@Column
	private int telefono;

	@Column
	private String contrasenha;
	
	@Column
	private int numero_perros;
	
	@ManyToOne
	private Rol rolDuenho = new Rol();
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	private List<Cacerias> cacerias = new ArrayList<Cacerias>();
	
	
	
	@OneToMany(mappedBy ="duenho", fetch=FetchType.EAGER)
	private List<Perros>listaPerros=new ArrayList<Perros>();*/

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
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

	
	

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	

	public int getNumero_perros() {
		return numero_perros;
	}

	public void setNumero_perros(int numero_perros) {
		this.numero_perros = numero_perros;
	}

	public Rol getRolDuenho() {
		return rolDuenho;
	}

	public void setRolDuenho(Rol rolDuenho) {
		this.rolDuenho = rolDuenho;
	}

	/*public List<Perros> getListaPerros() {
		return listaPerros;
	}

	public void setListaPerros(List<Perros> listaPerros) {
		this.listaPerros = listaPerros;
	}
	
	
	public List<Cacerias> getCacerias() {
		return cacerias;
	}

	public void setCacerias(List<Cacerias> cacerias) {
		this.cacerias = cacerias;
	}*/

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
		return "Duenho [usuario=" + usuario + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dirección=" + dirección + ", provincia=" + provincia + ", email=" + email + ", telefono="
				+ telefono + ", contrasenha=" + contrasenha + ", numero_perros=" + numero_perros + ", rolDuenho="
				+ rolDuenho + "]";
	}

	

	
	
	



	

	

}
