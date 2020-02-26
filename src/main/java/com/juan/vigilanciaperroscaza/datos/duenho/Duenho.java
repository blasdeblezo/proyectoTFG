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
	private String id_duenho;

	@Column
	private String DNI;

	@Column
	private String nombre;

	@Column
	private String Apellidos;

	@Column
	private String Dirección;

	@Column
	private String povincia;

	@Column
	private String email;

	@Column
	private int Telefono;

	@Column
	private String contrasenha;

	@ManyToOne
	private Rol rol = new Rol();	
	
	@OneToMany(mappedBy ="duenho", cascade = CascadeType.ALL)
	private List<Perros>listaPerros=new ArrayList<Perros>();
	
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

	private void addPerros(Perros perro) {
		if(!listaPerros.contains(perro)) {
			listaPerros.add(perro);
			perro.setDuenho(this);
		}
	}
	
	

		public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

		public List<Cacerias> getListaCecerias() {
		return listaCecerias;
	}



	public void setListaCecerias(List<Cacerias> listaCecerias) {
		this.listaCecerias = listaCecerias;
	}
	
	public List<Perros> getListaPerros() {
		return listaPerros;
	}


	public void setListaPerros(List<Perros> listaPerros) {
		this.listaPerros = listaPerros;
	}


	public String getPovincia() {
		return povincia;
	}

	public void setPovincia(String povincia) {
		this.povincia = povincia;
	}


	public String getId_duenho() {
		return id_duenho;
	}

	public void setId_duenho(String id_duenho) {
		this.id_duenho = id_duenho;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre()));
	    	    
	    return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		
		return this.contrasenha;
	}

	@Override
	public String getUsername() {
		
		return this.id_duenho;
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

}
