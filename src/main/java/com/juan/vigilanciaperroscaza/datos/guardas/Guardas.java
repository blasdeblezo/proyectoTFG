package com.juan.vigilanciaperroscaza.datos.guardas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.cacerias.Cacerias;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;

//Unir con la tabla de cacerias. Añadir en el proyecto el atributo Email y en los requisitos. 
@Entity
public class Guardas implements UserDetails {

	@Id
	private String id_guarda;

	@Column
	private String DNI;

	@Column
	private String nombre;

	@Column
	private String apellidos;

	@Column
	private int telefono;

	@Column
	private String email;

	@Column
	private String direccion;

	@Column
	private String provincia;

	
	
	@Column
	private String contrasenha;
	
	@ManyToOne
	private Rol rolguarda = new Rol();	
	
	@OneToMany(mappedBy = "guardas",cascade = CascadeType.ALL)
	private List<Cacerias>lisCacerias=new ArrayList<Cacerias>();
	
	

	public List<Cacerias> getLisCacerias() {
		return lisCacerias;
	}

	public void setLisCacerias(List<Cacerias> lisCacerias) {
		this.lisCacerias = lisCacerias;
	}
	
	


	public Rol getRolguarda() {
		return rolguarda;
	}

	public void setRolguarda(Rol rolguarda) {
		this.rolguarda = rolguarda;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}


	

	public String getId_guarda() {
		return id_guarda;
	}

	public void setId_guarda(String id_guarda) {
		this.id_guarda = id_guarda;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rolguarda.getNombre()));
		return null;
	}

	@Override
	public String getPassword() {
		
		return this.contrasenha;
	}

	@Override
	public String getUsername() {
	
		return this.id_guarda;
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
