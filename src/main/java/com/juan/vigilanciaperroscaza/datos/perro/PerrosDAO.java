package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;


//Hay que hacer las consultas a la base de datos
@Repository
public interface PerrosDAO extends CrudRepository<PerrosBD, String>{

	@Transactional @Query(value="SELECT COUNT(*) FROM perrosbd WHERE duenho_usuario=:nombre",nativeQuery=true)
	Integer numerodeperros(@Param("nombre") String nombre);

	List<PerrosBD> findByDuenho(DuenhoBD usuario);
	
	
	@Transactional @Query(value="SELECT * FROM perrosbd WHERE id_perro=:id",nativeQuery=true)
	PerrosBD ficha(@Param("id") String id);
	
	@Transactional @Query(value="SELECT * FROM perrosbd WHERE id_perro=:id",nativeQuery=true)
	PerrosBD perrorevision(@Param("id") String id);
	
	@Transactional @Query(value="SELECT * FROM perrosbd WHERE veterinarios_usuario=:usuario",nativeQuery=true)
	List<PerrosBD> perros(@Param("usuario") String usuario);
}
