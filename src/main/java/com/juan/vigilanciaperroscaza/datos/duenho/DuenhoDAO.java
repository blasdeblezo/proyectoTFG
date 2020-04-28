package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Hay que hacer las consultas a la base de datos
@Repository
public interface DuenhoDAO  extends CrudRepository<DuenhoBD, String>{

	DuenhoBD findByUsuario(String usuario);

	

}
