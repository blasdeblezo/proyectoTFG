package com.juan.vigilanciaperroscaza.datos.revisiones;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RevisionesDAO extends CrudRepository<RevisionesBD, Long>{
	
	
	@Transactional @Query(value = "select * from revisionesbd where perros_id_perro like %:id", nativeQuery = true)
	List<RevisionesBD> revisiones(@Param("id") String id);

}
