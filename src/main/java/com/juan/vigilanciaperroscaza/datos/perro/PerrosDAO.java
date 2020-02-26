package com.juan.vigilanciaperroscaza.datos.perro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Hay que hacer las consultas a la base de datos
@Repository
public interface PerrosDAO extends CrudRepository<Perros, Long>{

}
