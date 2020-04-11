package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaceriasRutas {

	@Autowired
	private CaceriasDAO caceriasDAO;
	
	
	@GetMapping("/listacacerias")
	public String listacacerias() {
		
		return "pagina_cacerias";
	}
	
	@GetMapping("/buscarCacerias")
	public ModelAndView buscarCacerias() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("caceria", new Cacerias());
		
		List<Cacerias>listaCacerias=(List<Cacerias>)caceriasDAO.findAll();
		mav.addObject("cacerias", listaCacerias);
		System.out.println(listaCacerias);
		
		mav.setViewName("pagina_cacerias");
		
		return mav;
	}
}
