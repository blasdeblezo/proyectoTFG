package com.juan.vigilanciaperroscaza.datos.perro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerrosRutas {

	@Autowired
	private PerrosDAO perrosDAO;
	
	@GetMapping("/listaperros")
	public String listacacerias() {
		
		return "pagina_perros";
	}
}
