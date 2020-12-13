package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.juan.vigilanciaperroscaza.datos.guardas.GuardasBD;

@Repository
public interface CaceriasDAO extends CrudRepository<CaceriasBD, Long>{

	List<CaceriasBD> findByGuardas(GuardasBD guarda);

	@Transactional @Query(value="select * from caceriasbd where provincia like %:pr "
			+ "and fecha like %:fc",nativeQuery=true)
	List<CaceriasBD> lista(@Param("pr")  String pr, @Param("fc") String fc);
	
	
	@Transactional @Query(value="select * from caceriasbd where id_caceria = :id", nativeQuery = true)
	CaceriasBD caceria(@Param ("id") Long id);

}
