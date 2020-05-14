package com.juan.vigilanciaperroscaza.datos.roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RolDAO extends CrudRepository<Rol, String>{
	
	@Transactional @Query(value="Select * from rol where nombre=:nombre",nativeQuery=true)
	Rol buscarRol(@Param("nombre") String nombre);
	
}
