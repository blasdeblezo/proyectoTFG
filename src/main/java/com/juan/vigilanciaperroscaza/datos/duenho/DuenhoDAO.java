package com.juan.vigilanciaperroscaza.datos.duenho;

import org.springframework.data.repository.CrudRepository;

public interface DuenhoDAO extends CrudRepository<DuenhoBD, String>{

	DuenhoBD findByUsuario(String usuario);

}
