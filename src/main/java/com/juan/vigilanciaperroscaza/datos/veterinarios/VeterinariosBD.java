package com.juan.vigilanciaperroscaza.datos.veterinarios;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;

// Unir con la tabla perros
@Entity
public class VeterinariosBD implements UserDetails{
	
	@Id
	@NotNull(message = "Usuario obligatorio")
	private String usuario;

	@Column
	@NotNull(message = "DNI obligatorio")
	private String dni;

	@Column
	@NotNull(message = "Nombre obligatorio")
	private String nombre;

	@Column
	@NotNull(message = "Apellidos obligatorio")
	private String apellidos;

	@Column
	@NotNull(message = "Dirección obligatoria")
	private String direccion;

	@Column
	@NotNull(message = "Provincia obligatoria")
	private String provincia;

	@Column
	@NotNull(message = "Correo obligatorio")
	private String email;

	@Column
	@NotNull(message = "Telefono obligatorio")
	private Integer telefono;

	@Column
	@NotNull(message = "Contraseña obligatoria")
	@Size(min=8, message = "La contraseña tiene que tener como mínimo 8 caracteres")
	@Pattern(regexp = "[a-zA-Z0-9]+", message="El código del producto solo puede tener letras minusculas, mayusculas o números")
	private String contrasenha;

	@ManyToOne
	private Rol rolVeterinario = new Rol();
	
	@OneToMany(mappedBy = "veterinarios",fetch = FetchType.EAGER )
	private List<PerrosBD>lisPerros=new ArrayList<PerrosBD>();


	

	public List<PerrosBD> getLisPerros() {
		return lisPerros;
	}

	public void setLisPerros(List<PerrosBD> lisPerros) {
		this.lisPerros = lisPerros;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

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
