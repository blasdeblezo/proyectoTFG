package com.juan.vigilanciaperroscaza.datos.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosDAO extends CrudRepository<Usuarios, String>{

}
