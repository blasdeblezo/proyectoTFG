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
	private Rol rolVeterinario = new Rol();
	
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

	

	public Rol getRolVeterinario() {
		return rolVeterinario;
	}

	public void setRolVeterinario(Rol rolVeterinario) {
		this.rolVeterinario = rolVeterinario;
	}

	public List<Perros> getLisPerros() {
		return lisPerros;
	}

	public void setLisPerros(List<Perros> lisPerros) {
		this.lisPerros = lisPerros;
	}

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
		return "Veterinarios [usuario=" + usuario + ", DNI=" + DNI + ", nombre=" + nombre + ", Apellidos=" + Apellidos
				+ ", Dirección=" + Dirección + ", provincia=" + provincia + ", email=" + email + ", Telefono="
				+ Telefono + ", contrasenha=" + contrasenha + ", rolVeterinario=" + rolVeterinario + ", lisPerros="
				+ lisPerros + "]";
	}
	
	
	
	
}
