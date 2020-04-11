package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.juan.vigilanciaperroscaza.datos.duenho.Duenho;


//Hay que hacer las consultas a la base de datos
@Repository
public interface PerrosDAO extends CrudRepository<Perros, Long>{

	@Transactional @Query(value="SELECT COUNT(*) FROM perros WHERE duenho_usuario=:nombre",nativeQuery=true)
	Integer numerodeperros(@Param("nombre") String nombre);

	List<Perros> findByDuenho(Duenho usuario);
	
	
}
