package com.juan.vigilanciaperroscaza.datos.veterinarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.perro.Perros;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
// Unir con la tabla perros
@Entity
public class Veterinarios implements UserDetails{

	@Id
	private String id_veterinario;
	
	@Column
	private String DNI;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String direccion;
	
	@Column
	private String email;
	
	@Column
	private int telefono;
	
	@Column
	private String contrasenha;
	
	@ManyToOne
	private Rol rolveterinarios = new Rol();	
	
	@ManyToMany(mappedBy = "veterinarios",cascade = CascadeType.ALL )
	private List<Perros>lisPerros=new ArrayList<Perros>();
	
	public void addPerros(Perros perro) {
		if(!lisPerros.contains(perro)) {
			lisPerros.add(perro);
			
			List<Veterinarios>lisVeterinarios=perro.getVeterinarios();
			if(!lisVeterinarios.contains(this)) {
				lisVeterinarios.add(this);
			}
		}
	}

	public List<Perros> getLisPerros() {
		return lisPerros;
	}

	public void setLisPerros(List<Perros> lisPerros) {
		this.lisPerros = lisPerros;
	}


	
	

	public String getId_veterinario() {
		return id_veterinario;
	}

	public void setId_veterinario(String id_veterinario) {
		this.id_veterinario = id_veterinario;
	}

	public Rol getRolveterinarios() {
		return rolveterinarios;
	}

	public void setRolveterinarios(Rol rolveterinarios) {
		this.rolveterinarios = rolveterinarios;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rolveterinarios.getNombre()));
	    	    
	    return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		
		return this.contrasenha;
	}

	@Override
	public String getUsername() {
		
		return this.id_veterinario;
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
