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
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.perro.Perros;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;

// Unir con la tabla perros
@Entity
public class Veterinarios implements UserDetails{
	
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
	private Rol rolVeterinario = new Rol();
	
	/*@ManyToMany(mappedBy = "veterinarios",cascade = CascadeType.ALL )
	private List<Perros>lisPerros=new ArrayList<Perros>();
	
	public void addPerros(Perros perro) {
		if(!lisPerros.contains(perro)) {
			lisPerros.add(perro);
			
			List<Veterinarios>lisVeterinarios=perro.getVeterinarios();
			if(!lisVeterinarios.contains(this)) {
				lisVeterinarios.add(this);
			}
		}
	}*/


	

	public Rol getRolVeterinario() {
		return rolVeterinario;
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

	public void setRolVeterinario(Rol rolVeterinario) {
		this.rolVeterinario = rolVeterinario;
	}

	/*public List<Perros> getLisPerros() {
		return lisPerros;
	}

	public void setLisPerros(List<Perros> lisPerros) {
		this.lisPerros = lisPerros;
	}*/

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rolVeterinario.getNombre()));
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
		return "Veterinarios [usuario=" + usuario + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", provincia=" + provincia + ", email=" + email + ", telefono="
				+ telefono + ", contrasenha=" + contrasenha + ", rolVeterinario=" + rolVeterinario + "]";
	}

	
	
	
	
}
