package com.juan.vigilanciaperroscaza.datos.veterinarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VeterinariosDAO extends CrudRepository<VeterinariosBD, String>{

	VeterinariosBD findByUsuario(String usuario);

}
