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
	private Rol rolGuarda = new Rol();
	
	/*@OneToMany(mappedBy = "guardas",cascade = CascadeType.ALL)
	private List<Cacerias>lisCacerias=new ArrayList<Cacerias>();*/

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

	
	public Rol getRolGuarda() {
		return rolGuarda;
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
	public String toString() {
		return "Guardas [usuario=" + usuario + ", DNI=" + DNI + ", nombre=" + nombre + ", Apellidos=" + Apellidos
				+ ", Dirección=" + Dirección + ", provincia=" + provincia + ", email=" + email + ", Telefono="
				+ Telefono + ", contrasenha=" + contrasenha + ", rol=" + rolGuarda  + "]";
	}
	
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

	
	
	


}
