package com.juan.vigilanciaperroscaza.datos.guardas;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GuardasDAO extends CrudRepository<GuardasBD, String>{

	GuardasBD findByUsuario(String usuario);
	
	
	@Transactional @Query(value="SELECT * FROM guardasbd WHERE provincia like %:pr and usuario like %:usu and nombre like %:nomb",nativeQuery=true)
	List<GuardasBD> lista(@Param("pr") String pr,@Param("usu") String usu, @Param("nomb") String nomb);

}
