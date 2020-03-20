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
	
	
	
	
	@GetMapping("/listacazadores")
	public String listacazadores() {
		
		return "pagina_duenhos";
	}
	
	
	@GetMapping("/buscarDuenhos")
	public ModelAndView busqueda(String id_duenho) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pagina_duenhos");
		mav.addObject("duenho",new Duenho());
		
		
		List<Duenho> listaDuenhos = (List<Duenho>)duenhoDAO.findAll();
		mav.addObject("duenhos",listaDuenhos);
		System.out.println(listaDuenhos);
		
		
		return mav;
		
	}
	
	@GetMapping("/registrarCazador")
	public String registrarCazadores() {
		
		return "registro_duenho";
		
	}
	
	
}
