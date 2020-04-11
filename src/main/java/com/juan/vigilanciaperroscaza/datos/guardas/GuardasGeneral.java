package com.juan.vigilanciaperroscaza.datos.guardas;


public class GuardasGeneral {
	
	
	private String usuario;

	
	private String dni;

	
	private String nombre;

	
	private String apellidos;


	private String direccion;


	private String provincia;


	private String email;


	private Integer telefono;

	
	private String contrasenha;


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


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public String getContrasenha() {
		return contrasenha;
	}


	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}


	@Override
	public String toString() {
		return "GuardasGeneral [usuario=" + usuario + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", provincia=" + provincia + ", email=" + email + ", telefono="
				+ telefono + ", contrasenha=" + contrasenha + "]";
	}
	
	
	
}
