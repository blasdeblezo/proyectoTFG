package com.juan.vigilanciaperroscaza.datos.veterinarios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface VeterinariosDAO extends CrudRepository<VeterinariosBD, String>{

	VeterinariosBD findByUsuario(String usuario);

	@Transactional @Query(value="SELECT * FROM veterinariosbd WHERE provincia like %:pr  and usuario like %:usu and nombre like %:nomb",nativeQuery=true)
	List<VeterinariosBD> lista(@Param("pr")String pr, @Param("usu") String usu, @Param("nomb") String nomb);

}
