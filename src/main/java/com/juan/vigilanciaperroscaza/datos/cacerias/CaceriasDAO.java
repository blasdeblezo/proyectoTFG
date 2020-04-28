package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juan.vigilanciaperroscaza.datos.guardas.GuardasBD;

@Repository
public interface CaceriasDAO extends CrudRepository<CaceriasBD, Long>{

	List<CaceriasBD> findByGuardas(GuardasBD guarda);

}
