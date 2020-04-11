package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juan.vigilanciaperroscaza.datos.guardas.Guardas;

@Repository
public interface CaceriasDAO extends CrudRepository<Cacerias, Long>{

	List<Cacerias> findByGuardas(Guardas guarda);

}
