package com.juan.vigilanciaperroscaza;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasPrincipales {
	
	
	@GetMapping("/")
	public String seguridad(HttpSession sesion) {
		
		
		
		return "paginadeinicio";
	}	
	

}
