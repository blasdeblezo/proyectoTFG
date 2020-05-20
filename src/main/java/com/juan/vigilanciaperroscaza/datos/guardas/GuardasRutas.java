package com.juan.vigilanciaperroscaza.datos.guardas;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.cacerias.CaceriasBD;
import com.juan.vigilanciaperroscaza.datos.cacerias.CaceriasDAO;
import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.roles.RolDAO;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;

import antlr.debug.GuessingEvent;

@Controller
public class GuardasRutas {

	@Autowired
	private GuardasDAO guardasDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@Autowired
	private ProvinciasDAO provinciasDAO;
	
	@Autowired
	private CaceriasDAO caceriasDAO;
	
	@GetMapping("/listaguardas")
	public ModelAndView listaguardas() {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.setViewName("pagina_guardas");
		
		return mav;
		
		
	}
	
	@GetMapping("/registrarGuarda")
	public ModelAndView registrarGuarda() {
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("guardaRegistrado", new Guardas());
		mav.addObject("listaprovincias", provincia);
		mav.setViewName("registro_guardas");
		
		return mav;
	}
	
	@PostMapping("/guardarGuarda")
	public ModelAndView guardadGuarda(@Valid @ModelAttribute("guardaRegistrado") Guardas guardaRegistrado) {
		
		Rol rol=new Rol();
		rol=rolDAO.buscarRol("guarda");
		
		ModelAndView mav=new ModelAndView();
		GuardasBD guarda = CrearGuarda(guardaRegistrado, rol);
		
		guardasDAO.save(guarda);
		mav.setViewName("registro_guardas");
		
		return mav;
	}


	
	@GetMapping("/buscarGuardas")
	public ModelAndView buscarGuardas() {
		List<GuardasBD> listaGuardas=(List<GuardasBD>)guardasDAO.findAll();
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_guardas");
		mav.addObject("guarda", new GuardasBD());
		mav.addObject("listaprovincias", provincia);
		
		
		mav.addObject("guardas", listaGuardas);
		
		
		return mav;
	}
	
	@GetMapping("/fichaGuarda/{usuario}")
	public ModelAndView fichaGuarda(@PathVariable String usuario) {
		
		ModelAndView mav=new ModelAndView();
		GuardasBD guarda=guardasDAO.findByUsuario(usuario);
		mav.addObject("guarda", guarda);
		
		
		GuardasBD usuarioG=new GuardasBD();
		usuarioG.setUsuario(usuario);
		List<CaceriasBD> listaCacerias=(List<CaceriasBD>)caceriasDAO.findByGuardas(usuarioG);
		mav.addObject("cacerias", listaCacerias);
		
		
		mav.setViewName("ficha_guarda");
		
		return mav;
	}
	
	@GetMapping("/editarGuarda/{usuario}")
	public ModelAndView editarGuarda(@PathVariable String usuario) {
		
		ModelAndView mav=new ModelAndView();
		GuardasBD guarda=guardasDAO.findByUsuario(usuario);
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();

		mav.addObject("guarda", guarda);
		mav.addObject("listaprovincias", provincia);
		
		
		mav.setViewName("editar_guarda");
		
		return mav;
	}
	
	@PostMapping("/guardaEditado")
	public ModelAndView guardaEditado(
			@Valid @ModelAttribute("guarda") GuardasBD guardasBD) {
			System.out.println(guardasBD);
			
			ModelAndView mav=new ModelAndView();
			guardasDAO.save(guardasBD);
			mav.setViewName("ficha_guarda");
			
			return mav;
		
	}
	@GetMapping("/eliminarGuarda/{usuario}")
	public ModelAndView eliminarGuerda(@PathVariable String usuario) {
		guardasDAO.deleteById(usuario);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_guardas");
		
		return mav;
		
		
	}
	
	
	public GuardasBD CrearGuarda(Guardas guardaRegistrado, Rol rol) {
		GuardasBD guarda=new GuardasBD();
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
		return guarda;
	}
}
