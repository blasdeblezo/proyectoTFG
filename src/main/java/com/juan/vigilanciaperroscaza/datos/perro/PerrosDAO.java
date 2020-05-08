package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;


//Hay que hacer las consultas a la base de datos
@Repository
public interface PerrosDAO extends CrudRepository<PerrosBD, Long>{

	@Transactional @Query(value="SELECT COUNT(*) FROM perrosbd WHERE duenho_usuario=:nombre",nativeQuery=true)
	Integer numerodeperros(@Param("nombre") String nombre);

	List<PerrosBD> findByDuenho(DuenhoBD usuario);
	
	
}
