package com.juan.vigilanciaperroscaza.datos.duenho;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.perro.Perros;
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
	
	@GetMapping("/listaduenhos")
	public String listacazadores() {
		
		return "pagina_duenhos";
	}
	
	
	@GetMapping("/buscarDuenhos")
	public ModelAndView busqueda() {
		
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
		mav.addObject("duenhoregistro", new DuenhosGeneral());
		
		
		return mav;
		
		
		
	}
	
	@PostMapping("/guardarDuenho")
	public ModelAndView guardarDuenhos(
			@Valid @ModelAttribute("duenhoregistro") DuenhosGeneral duenhoregistro,
								Errors errores) {
		
		Rol rol=new Rol();
		rol=rolDAO.buscarDuenho("usuario");
		
		int n=perrosDAO.numerodeperros(duenhoregistro.getUsuario());
		
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
		duenho.setNumero_perros(n);
		duenho.setRolDuenho(rol);
		mav.setViewName("registro_duenho");
		
		
		duenhoDAO.save(duenho);
		
		return mav;
		
	}
	
	@GetMapping("/fichaDuenho/{usuario}")
	public ModelAndView fichaDuenho(
			@PathVariable String usuario) {
		
		ModelAndView mav=new ModelAndView();
		
		Duenho duenho=duenhoDAO.findByUsuario(usuario);
		mav.addObject("duenhoFicha", duenho);
		System.out.println(duenho);
		
		Duenho usuarioD=new Duenho();
		usuarioD.setUsuario(usuario);
		List<Perros> perros=(List<Perros>)perrosDAO.findByDuenho(usuarioD);
		mav.addObject("perros", perros);
		System.out.println(perros);
		
		mav.setViewName("ficha_duenho");
		return mav;
	}
	
	@GetMapping("/editarDuenho/{usuario}")
	public ModelAndView editarDuenho(@PathVariable String usuario) {
		
		Duenho duenho=duenhoDAO.findById(usuario).get();
		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("editar_duenho");
		mav.addObject("duenhoEditado", duenho);
	
		
		return mav;
	}
	
	@PostMapping("/duenhoEditado")
	public ModelAndView duenhoEditado(
			@Valid @ModelAttribute("duenhoEditado") Duenho duenho) {
		
		System.out.println(duenho);
		
		ModelAndView mav=new ModelAndView();
		duenhoDAO.save(duenho);
		mav.setViewName("pagina_duenhos");
		
		return mav;
	}
	
	@GetMapping("/eliminarDuenho/{usuario}")
	public ModelAndView eliminarDuenho(@PathVariable String usuario) {
		duenhoDAO.deleteById(usuario);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_duenhos");
		
		return mav;
		
		
	}
	
}
