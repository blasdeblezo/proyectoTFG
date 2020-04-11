package com.juan.vigilanciaperroscaza.datos.cacerias;



public class CaceriasGeneral {
	

	private Long id_caceria;


	private String provincia;


	private String fecha;


	private Integer numero_perros;


	private Integer numero_cazadores;

	

	public Long getId_caceria() {
		return id_caceria;
	}


	public void setId_caceria(Long id_caceria) {
		this.id_caceria = id_caceria;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Integer getNumero_perros() {
		return numero_perros;
	}


	public void setNumero_perros(Integer numero_perros) {
		this.numero_perros = numero_perros;
	}


	public Integer getNumero_cazadores() {
		return numero_cazadores;
	}


	public void setNumero_cazadores(Integer numero_cazadores) {
		this.numero_cazadores = numero_cazadores;
	}


	@Override
	public String toString() {
		return "CaceriasGeneral [id_caceria=" + id_caceria + ", provincia=" + provincia + ", fecha=" + fecha
				+ ", numero_perros=" + numero_perros + ", numero_cazadores=" + numero_cazadores + "]";
	}
	
	
	

}
