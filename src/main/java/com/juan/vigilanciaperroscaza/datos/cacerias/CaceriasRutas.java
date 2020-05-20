package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;

@Controller
public class CaceriasRutas {

	@Autowired
	private CaceriasDAO caceriasDAO;
	@Autowired
	private ProvinciasDAO provinciasDAO;
	
	@GetMapping("/listacacerias")
	public ModelAndView listacacerias() {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.setViewName("pagina_cacerias");
		
		return mav;
		
	
	}
	
	@GetMapping("/buscarCacerias")
	public ModelAndView buscarCacerias() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("caceria", new CaceriasBD());
		
		List<CaceriasBD>listaCacerias=(List<CaceriasBD>)caceriasDAO.findAll();
		mav.addObject("cacerias", listaCacerias);
		System.out.println(listaCacerias);
		
		mav.setViewName("pagina_cacerias");
		
		return mav;
	}
	
	@GetMapping("/registrarCaceria")
	public ModelAndView registroCacerias() {
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("caceriaRegistrada", new CaceriasBD());
		mav.setViewName("registro_caceria");
		
		return mav;
	}
}
