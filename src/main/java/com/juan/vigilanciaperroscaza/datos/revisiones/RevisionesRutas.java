package com.juan.vigilanciaperroscaza.datos.revisiones;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;
import com.juan.vigilanciaperroscaza.datos.perro.PerrosDAO;

@Controller
public class RevisionesRutas {
	
	@Autowired
	private RevisionesDAO revisionesDAO;
	
	@Autowired
	private PerrosDAO perrosDAO;
	
	
	@GetMapping("/revisionNueva/{id}")
	public ModelAndView crearRevision(@Valid @PathVariable String id) {
		
		PerrosBD perro= perrosDAO.perrorevision(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("perro", perro);
		mav.addObject("revision", new RevisionesBD());
		mav.setViewName("crear_revision");
		
		return mav;
	}
	
	@PostMapping("/editadoRevision")
	public ModelAndView editarRevision( @Valid @ModelAttribute("revision") RevisionesBD revision) {
		
		System.out.println(revision);
		
		revisionesDAO.save(revision);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pagina_perros");
		
		return mav;
	}
	
	

}
