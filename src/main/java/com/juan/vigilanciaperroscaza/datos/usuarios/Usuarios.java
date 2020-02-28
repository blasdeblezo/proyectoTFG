package com.juan.vigilanciaperroscaza.datos.usuarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.duenho.Duenho;
import com.juan.vigilanciaperroscaza.datos.guardas.Guardas;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.veterinarios.Veterinarios;

@Entity
public class Usuarios implements UserDetails{
	
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
	private String povincia;

	@Column
	private String email;

	@Column
	private int Telefono;

	@Column
	private String contrasenha;

	@ManyToOne
	private Rol rol = new Rol();
	
	
	@OneToOne(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private Duenho duenho;
	
	@OneToOne(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private Veterinarios veterinarios;
	
	@OneToOne(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private Guardas guardas;;
	

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

	public String getPovincia() {
		return povincia;
	}

	public void setPovincia(String povincia) {
		this.povincia = povincia;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Duenho getDueño() {
		return duenho;
	}

	public void setDueño(Duenho dueño) {
		this.duenho = dueño;
	}
	
	

	public Duenho getDuenho() {
		return duenho;
	}

	public void setDuenho(Duenho duenho) {
		this.duenho = duenho;
	}
	
	public Veterinarios getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(Veterinarios veterinarios) {
		this.veterinarios = veterinarios;
	}

	public Guardas getGuardas() {
		return guardas;
	}

	public void setGuardas(Guardas guardas) {
		this.guardas = guardas;
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
	
	

}
