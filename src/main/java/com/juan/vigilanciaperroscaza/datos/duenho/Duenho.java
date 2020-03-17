package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.ArrayList;


import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
	private String Apellidos;

	@Column
	private String Dirección;

	@Column
	private String provincia;

	@Column
	private String email;

	@Column
	private int Telefono;

	@Column
	private String contrasenha;

	@ManyToOne
	private Rol rolDuenho = new Rol();
	
	
	@ManyToMany(mappedBy = "duenhos",cascade = CascadeType.ALL)
	private List<Cacerias> listaCecerias=new ArrayList<Cacerias>();
	
	public void addCacerias(Cacerias caceria) {
		if(!listaCecerias.contains(caceria)) {
			listaCecerias.add(caceria);
			
			List<Duenho>listaDuenhos=caceria.getDuenhos();
			if(!listaDuenhos.contains(this)) {
				listaDuenhos.add(this);
			}
		}
	}
	
	@OneToMany(mappedBy ="duenho", cascade = CascadeType.ALL)
	private List<Perros>listaPerros=new ArrayList<Perros>();

	private void addPerros(Perros perro) {
		if(!listaPerros.contains(perro)) {
			listaPerros.add(perro);
			perro.setDuenho(this);
		}
	}

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
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDirección() {
		return Dirección;
	}

	public void setDirección(String dirección) {
		Dirección = dirección;
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
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	

	public Rol getRolDuenho() {
		return rolDuenho;
	}

	public void setRolDuenho(Rol rolDuenho) {
		this.rolDuenho = rolDuenho;
	}

	public List<Perros> getListaPerros() {
		return listaPerros;
	}

	public void setListaPerros(List<Perros> listaPerros) {
		this.listaPerros = listaPerros;
	}

	public List<Cacerias> getListaCecerias() {
		return listaCecerias;
	}

	public void setListaCecerias(List<Cacerias> listaCecerias) {
		this.listaCecerias = listaCecerias;
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
		return "Duenho [usuario=" + usuario + ", DNI=" + DNI + ", nombre=" + nombre + ", Apellidos=" + Apellidos
				+ ", Dirección=" + Dirección + ", provincia=" + provincia + ", email=" + email + ", Telefono="
				+ Telefono + ", contrasenha=" + contrasenha + ", rol=" + rolDuenho + ", listaPerros=" + listaPerros
				+ ", listaCecerias=" + listaCecerias + "]";
	}
	
	
	



	

	

}
