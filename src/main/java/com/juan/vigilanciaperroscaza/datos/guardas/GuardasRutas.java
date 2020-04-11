package com.juan.vigilanciaperroscaza.datos.guardas;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.roles.RolDAO;

@Controller
public class GuardasRutas {

	@Autowired
	private GuardasDAO guardasDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@GetMapping("/listaguardas")
	public String listaguardas() {
		
		return "pagina_guardas";
	}
	
	@GetMapping("/registrarGuarda")
	public ModelAndView registrarGuarda() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("guardaRegistrado", new GuardasGeneral());
		mav.setViewName("registro_guardas");
		
		return mav;
	}
	
	@PostMapping("/guardarGuarda")
	public ModelAndView guardadGuarda(@Valid @ModelAttribute("guardaRegistrado") GuardasGeneral guardaRegistrado) {
		
		Rol rol=new Rol();
		rol=rolDAO.buscarDuenho("guarda");
		
		ModelAndView mav=new ModelAndView();
		
		Guardas guarda=new Guardas();
		guarda.setUsuario(guardaRegistrado.getUsuario());
		guarda.setNombre(guardaRegistrado.getNombre());
		guarda.setApellidos(guardaRegistrado.getApellidos());
		guarda.setDireccion(guardaRegistrado.getDireccion());
		guarda.setDni(guardaRegistrado.getDni());
		guarda.setEmail(guardaRegistrado.getEmail());
		guarda.setProvincia(guardaRegistrado.getProvincia());
		guarda.setTelefono(guardaRegistrado.getTelefono());
		guarda.setRolGuarda(rol);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		guarda.setContrasenha(passwordEncoder.encode(guardaRegistrado.getContrasenha()));
		
		guardasDAO.save(guarda);
		mav.setViewName("registro_guardas");
		
		return mav;
	}
	
	@GetMapping("/buscarGuardas")
	public ModelAndView buscarGuardas() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_guardas");
		mav.addObject("guarda", new Guardas());
		
		List<Guardas> listaGuardas=(List<Guardas>)guardasDAO.findAll();
		mav.addObject("guardas", listaGuardas);
		System.out.println(listaGuardas);
		
		return mav;
	}
}
