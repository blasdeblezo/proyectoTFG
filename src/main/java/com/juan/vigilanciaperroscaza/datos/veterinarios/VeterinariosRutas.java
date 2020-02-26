package com.juan.vigilanciaperroscaza.datos.veterinarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VeterinariosRutas {

	
	@Autowired
	private VeterinariosDAO veterinariosDAO;
	
	@GetMapping("/listaveterinarios")
	public String listacacerias() {
		
		return "pagina_veterinarios";
	}
}
