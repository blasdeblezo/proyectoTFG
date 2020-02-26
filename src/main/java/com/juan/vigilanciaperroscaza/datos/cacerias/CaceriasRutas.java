package com.juan.vigilanciaperroscaza.datos.cacerias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaceriasRutas {

	@Autowired
	private CaceriasDAO caceriasDAO;
	
	
	@GetMapping("/listacacerias")
	public String listacacerias() {
		
		return "pagina_cacerias";
	}
}
