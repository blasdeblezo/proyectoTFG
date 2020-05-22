package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DuenhoDAO extends CrudRepository<DuenhoBD, String>{

	DuenhoBD findByUsuario(String usuario);
	
	@Transactional @Query(value="SELECT * FROM duenhobd WHERE provincia like %:pr and usuario like %:usu and nombre like %:nomb",nativeQuery=true)
	List<DuenhoBD> lista(@Param("pr")  String pr,@Param("usu") String usu, @Param("nomb") String nomb);

	
	 

}
