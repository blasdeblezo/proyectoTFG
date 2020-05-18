package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoDAO;

@Controller
public class PerrosRutas {

	@Autowired
	private PerrosDAO perrosDAO;
	
	@Autowired
	private DuenhoDAO duenhoDAO;
	
	
	
	@GetMapping("/listaperros")
	public String listaperros() {
		
		return "pagina_perros";
	}
	
	@GetMapping("/registrarPerro")
	public ModelAndView regidtrarPerro() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("perroRegistrado", new PerrosBD());
		
		List<DuenhoBD> listaDuenhos = (List<DuenhoBD>)duenhoDAO.findAll();
		mav.addObject("listaduenhos", listaDuenhos);
		System.out.println(listaDuenhos);
		
		mav.setViewName("registro_perro");
		return mav;
	}
	
	@PostMapping("/guardarPerro")
	public ModelAndView guardarPerro(@Valid @ModelAttribute("perroRegistrado") PerrosBD perroBD) {
		
		ModelAndView mav=new ModelAndView();
		
		System.out.println(perroBD);
		perrosDAO.save(perroBD);
		
		mav.setViewName("paginadeinicio");
		
		return mav;
	}
	
	@GetMapping("/buscarPerro")
	public ModelAndView buscarPerro() {
		
		List<PerrosBD> listaPerros=(List<PerrosBD>) perrosDAO.findAll();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaPerros", listaPerros);
		System.out.println(listaPerros);
		mav.setViewName("pagina_perros");

		
		
		return mav;
	}
	
	@GetMapping("eliminarPerro/{id}")
	public ModelAndView eliminarPerro(@PathVariable Long id) {
		
		perrosDAO.deleteById(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_perros");
		return mav;
	}




	
}
