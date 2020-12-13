package com.juan.vigilanciaperroscaza.datos.provincias;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.juan.vigilanciaperroscaza.datos.cacerias.CaceriasBD;

public interface ProvinciasDAO  extends CrudRepository<Provincias, String>{

	List<Provincias> findAll();

	
}
