package com.juan.vigilanciaperroscaza.datos.duenho;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;
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
		
		
		
		List<DuenhoBD> listaDuenhos = (List<DuenhoBD>)duenhoDAO.findAll();
		mav.addObject("duenhos",listaDuenhos);
		
		
		
		return mav;
		
	}
	
	@GetMapping("/registrarCazador")
	public ModelAndView registrarCazadores() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("registro_duenho");
		mav.addObject("duenhoregistro", new Duenhos());
		
		
		return mav;
		
		
		
	}
	
	@PostMapping("/guardarDuenho")
	public ModelAndView guardarDuenhos(
			@Valid @ModelAttribute("duenhoregistro") Duenhos duenhoregistro,
								Errors errores) {
		Rol rol=new Rol();
		rol=rolDAO.buscarRol("usuario");
		
		ModelAndView mav = new ModelAndView();	
		DuenhoBD duenho = GenerarDuenho(duenhoregistro, rol);
		
		duenhoDAO.save(duenho);
		
		mav.setViewName("registro_duenho");
		return mav;
		
	}



	@GetMapping("/fichaDuenho/{usuario}")
	public ModelAndView fichaDuenho(
			@PathVariable String usuario) {
		
		ModelAndView mav=new ModelAndView();
		
		DuenhoBD duenho=duenhoDAO.findByUsuario(usuario);
		System.out.println(duenho);
		mav.addObject("duenhoFicha", duenho);
		
		
		
		/*DuenhoBD usuarioD=new DuenhoBD();
		usuarioD.setUsuario(usuario);
		List<PerrosBD> perros=(List<PerrosBD>)perrosDAO.findByDuenho(usuarioD);
		mav.addObject("perros", perros);
		System.out.println(perros);*/
		
		mav.setViewName("ficha_duenho");
		return mav;
	}
	

	@GetMapping("/editarDuenho/{usuario}")
	public ModelAndView editarDuenho(@PathVariable String usuario) {
		
		DuenhoBD duenho=duenhoDAO.findById(usuario).get();
		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("editar_duenho");
		mav.addObject("duenhoEditado", duenho);
	
		
		return mav;
	}
	
	@PostMapping("/duenhoEditado")
	public ModelAndView duenhoEditado(
			@Valid @ModelAttribute("duenhoEditado") DuenhoBD duenho) {
		
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
	
	public DuenhoBD GenerarDuenho(Duenhos duenhoregistro, Rol rol) {
		DuenhoBD duenho=new DuenhoBD();
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
		duenho.setNumero_perros(duenho.getListaPerros().size());
		duenho.setRolDuenho(rol);
		duenho.setAviso(duenhoregistro.getAviso());
		return duenho;
	}
	
	
}
