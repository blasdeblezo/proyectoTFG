package com.juan.vigilanciaperroscaza.datos.veterinarios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;
import com.juan.vigilanciaperroscaza.datos.perro.PerrosDAO;
import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.roles.RolDAO;

@Controller
public class VeterinariosRutas {

	
	@Autowired
	private VeterinariosDAO veterinariosDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@Autowired
	private ProvinciasDAO provinciasDAO;
	
	@Autowired
	private PerrosDAO perrosDAO;
	
	@GetMapping("/listaveterinarios")
	public ModelAndView listaVeterinarios() {
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		Veterinarios filtroVeterinario=new Veterinarios();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("listaprovincias", provincia);
		mav.addObject("filtroVeterinarios", filtroVeterinario);
		mav.setViewName( "pagina_veterinarios");
		
		return mav;
	}
	
	@GetMapping("/registrarVeterinario")
	public ModelAndView registrarVeterinario() {
		
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("veterinario", new Veterinarios());
		mav.setViewName("registrar_veterinarios");
		mav.addObject("listaprovincias", provincia);
		
		
		return mav;
		
	}
	@PostMapping("/guardarVeterinario")
	public ModelAndView guardarVeterinario(
			@Valid @ModelAttribute("veterinario") Veterinarios veterinarioRegistrado) {
		
		Rol rol=new Rol();
		rol=rolDAO.buscarRol("veterinario");
		
		ModelAndView mav=new ModelAndView();
		
		VeterinariosBD veterinariosBD=CrearVeterinario(veterinarioRegistrado, rol);
		System.out.println(veterinariosBD);
		
		veterinariosDAO.save(veterinariosBD);
		mav.setViewName("registrar_veterinario");
		return mav;
	}

	@GetMapping("/buscarVeterinarios")
	public ModelAndView buscarVeterinarios(@Valid @ModelAttribute("filtroVeterinarios") Veterinarios  filtro) {
		
		
		String pr=filtro.getProvincia();
		String usu=filtro.getUsuario();
		String nomb=filtro.getNombre();
		
		if(pr == null) {
			pr = "%";
		}
		
		if(usu == null) {
			usu = "%";
		}
		
		if(nomb == null) {
			nomb = "%";
		}
		
		
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		List<VeterinariosBD> listaVeteriniarios=(List<VeterinariosBD>) veterinariosDAO.lista(pr, usu, nomb);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaVeterinarios", listaVeteriniarios);
		mav.addObject("listaprovincias",provincia);
		mav.setViewName("pagina_veterinarios");
		
		return mav;
	}
	
	@GetMapping("fichaVeterinario/{usuario}")
	public ModelAndView fichaVeterinario(@PathVariable String usuario) {
		
		System.out.println(usuario);
		VeterinariosBD veterinariosBD=veterinariosDAO.findByUsuario(usuario);
		List<PerrosBD> perros=(List<PerrosBD>)perrosDAO.perros(usuario);
		System.out.println(perros);
		ModelAndView mav=new ModelAndView();
		mav.addObject("veterinario", veterinariosBD);
		mav.addObject("listaperros", perros);
		
	
		mav.setViewName("ficha_veterinario");
		
		
		return mav;
	}
	
	@GetMapping("/editarVeterinario/{usuario}")
	public ModelAndView editarVeterinario(@PathVariable String usuario) {
		VeterinariosBD veterinario=veterinariosDAO.findByUsuario(usuario);
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("veterinario", veterinario);
		mav.addObject("listaprovincias", provincia);
		mav.setViewName("editar_veterinario");
		
		
		return mav;
	}
	
	@PostMapping("/veterinarioEditado")
	public ModelAndView veterinarioEditado(
			@Valid @ModelAttribute("veterinario") VeterinariosBD veterinariosBD) {
		
		veterinariosDAO.save(veterinariosBD);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("ficha_veterinario");
		
		return mav;
		
	}
	
	@GetMapping("/eliminarVeterinario/{usuario}")
	public ModelAndView eliminarVeterinario(@PathVariable String usuario) {
		veterinariosDAO.deleteById(usuario);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_veterinarios");
		
		return mav;
		
	}
	
	
	public VeterinariosBD CrearVeterinario(Veterinarios veterinarioRegistrado, Rol rol) {
		
		VeterinariosBD veterinario=new VeterinariosBD();
		veterinario.setUsuario(veterinarioRegistrado.getUsuario());
		veterinario.setDni(veterinarioRegistrado.getDni());
		veterinario.setNombre(veterinarioRegistrado.getNombre());
		veterinario.setApellidos(veterinarioRegistrado.getApellidos());
		veterinario.setDireccion(veterinarioRegistrado.getDireccion());
		veterinario.setProvincia(veterinarioRegistrado.getProvincia());
		veterinario.setEmail(veterinarioRegistrado.getEmail());
		veterinario.setTelefono(veterinarioRegistrado.getTelefono());
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		veterinario.setContrasenha(passwordEncoder.encode(veterinarioRegistrado.getContrasenha()));
		veterinario.setRolVeterinario(rol);
		
		return veterinario;
	}
}
