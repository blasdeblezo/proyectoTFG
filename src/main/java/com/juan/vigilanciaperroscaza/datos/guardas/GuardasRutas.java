package com.juan.vigilanciaperroscaza.datos.guardas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuardasRutas {

	@Autowired
	private GuardasDAO guardasDAO;
	
	@GetMapping("/listaguardas")
	public String listacacerias() {
		
		return "pagina_guardas";
	}
}
