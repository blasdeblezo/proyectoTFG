package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.roles.RolDAO;



@Controller
public class DuenhoRutas {

	
	@Autowired
	private DuenhoDAO duenhoDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	
	@GetMapping("/listacazadores")
	public String listacacerias() {
		
		return "pagina_duenhos";
	}
	
	
	@GetMapping("/buscarUsuarios")
	public ModelAndView busqueda(String id_duenho) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("duenhos");
		mav.addObject("duenho",new Duenho());
		
		List<Duenho> listaDuenhos = (List<Duenho>)duenhoDAO.findByIdDuenhos(id_duenho);
		mav.addObject("duenhos",listaDuenhos);
		
		List<Rol> listaRoles = (List<Rol>)rolDAO.findAll();
		mav.addObject("roles",listaRoles);
		
		return mav;
		
	}
	
	
}
