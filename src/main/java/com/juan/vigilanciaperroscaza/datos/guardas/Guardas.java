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
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.cacerias.Cacerias;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;


@Entity
public class Guardas implements UserDetails{

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
	private int telefono;

	@Column
	private String contrasenha;

	@ManyToOne
	private Rol rolGuarda = new Rol();
	
	/*@OneToMany(mappedBy = "guardas",cascade = CascadeType.ALL)
	private List<Cacerias>lisCacerias=new ArrayList<Cacerias>();*/

	

	

	
	public Rol getRolGuarda() {
		return rolGuarda;
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

	public void setRolGuarda(Rol rolGuarda) {
		this.rolGuarda = rolGuarda;
	}

	/*public List<Cacerias> getLisCacerias() {
		return lisCacerias;
	}

	public void setLisCacerias(List<Cacerias> lisCacerias) {
		this.lisCacerias = lisCacerias;
	}*/

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rolGuarda.getNombre()));
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
		return "Guardas [usuario=" + usuario + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", provincia=" + provincia + ", email=" + email + ", telefono="
				+ telefono + ", contrasenha=" + contrasenha + ", rolGuarda=" + rolGuarda + "]";
	}

	
	
	


}
