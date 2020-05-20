package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.List;
import java.util.Optional;

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
import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;

@Controller
public class PerrosRutas {

	@Autowired
	private PerrosDAO perrosDAO;
	
	@Autowired
	private DuenhoDAO duenhoDAO;
	
	@Autowired
	private ProvinciasDAO provinciasDAO;
	
	
	@GetMapping("/listaperros")
	public ModelAndView listaperros() {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.setViewName( "pagina_perros");
		
		return mav;
		
		
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
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaPerros", listaPerros);
		mav.addObject("listaprovincias", provincia);
		System.out.println(listaPerros);
		mav.setViewName("pagina_perros");

		
		
		return mav;
	}
	
	@GetMapping("/fichaPerro/{id}")
	public ModelAndView fichaPerro(@PathVariable String id) {
		
		PerrosBD perro=perrosDAO.ficha(id);
		ModelAndView mav=new ModelAndView();
		
		System.out.println(perro);
		mav.addObject("perro", perro);
		mav.setViewName("ficha_perro");
		
		return mav;
	}
	
	@GetMapping("/editarPerro/{id}")
	public ModelAndView editarPerro(@PathVariable String id) {
		
		PerrosBD perro=perrosDAO.ficha(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("perro", perro);
		mav.setViewName("editar_perro");
		
		return mav;
		
	}
	
	@GetMapping("eliminarPerro/{id}")
	public ModelAndView eliminarPerro(@PathVariable String id) {
		
		perrosDAO.deleteById(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_perros");
		return mav;
	}




	
}
