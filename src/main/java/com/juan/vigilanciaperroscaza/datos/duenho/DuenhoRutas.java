package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosDAO;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.roles.RolDAO;






@Controller
public class DuenhoRutas {

	
	@Autowired
	private DuenhoDAO duenhoDAO;
	
	@Autowired
	private PerrosDAO perrosDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
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
		
		
		
		return mav;
		
	}
	
	@GetMapping("/registrarCazador")
	public ModelAndView registrarCazadores() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("registro_duenho");
		mav.addObject("duenhoregistro", new DuenhoRegistro());
		
		
		return mav;
		
		
		
	}
	
	@PostMapping("/guardarDuenho")
	public ModelAndView guardarDuenhos(
			@Valid @ModelAttribute("duenhoregistro") DuenhoRegistro duenhoregistro,
								Errors errores) {
		
		Rol rol=new Rol();
		rol=rolDAO.buscarDuenho("usuario");
		
		ModelAndView mav = new ModelAndView();
		
		Duenho duenho=new Duenho();
		duenho.setUsuario(duenhoregistro.getUsuario());
		duenho.setDni(duenhoregistro.getDni());
		duenho.setNombre(duenhoregistro.getNombre());
		duenho.setApellidos(duenhoregistro.getApellidos());
		duenho.setDireccion(duenhoregistro.getDireccion());
		duenho.setProvincia(duenhoregistro.getProvincia());
		duenho.setEmail(duenhoregistro.getEmail());
		duenho.setTelefono(duenhoregistro.getTelefono());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		duenho.setContrasenha((passwordEncoder.encode(duenhoregistro.getContrasenha())));
		//duenho.setNumero_perros(duenhoregistro.getNumero_perros());
		duenho.setRolDuenho(rol);
		System.out.println(duenho);
		System.out.println(duenhoregistro);
		mav.setViewName("registro_duenho");
		
		
		
		duenhoDAO.save(duenho);
		
		return mav;
		
	}
	
}
