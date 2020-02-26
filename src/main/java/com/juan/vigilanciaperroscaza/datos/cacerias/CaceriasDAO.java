package com.juan.vigilanciaperroscaza.datos.cacerias;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaceriasDAO extends CrudRepository<Cacerias, Long>{

}
