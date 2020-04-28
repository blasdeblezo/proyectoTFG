package com.juan.vigilanciaperroscaza.datos.guardas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardasDAO extends CrudRepository<GuardasBD, String>{

	GuardasBD findByUsuario(String usuario);

}
