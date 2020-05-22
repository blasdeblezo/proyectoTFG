package com.juan.vigilanciaperroscaza.datos.duenho;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
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
import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;
import com.juan.vigilanciaperroscaza.datos.roles.Rol;
import com.juan.vigilanciaperroscaza.datos.roles.RolDAO;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;






@Controller
public class DuenhoRutas {

	
	@Autowired
	private DuenhoDAO duenhoDAO;
	
	@Autowired
	private PerrosDAO perrosDAO;
	
	@Autowired
	private ProvinciasDAO provinciasDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@GetMapping("/listaduenhos")
	public ModelAndView listacazadores() {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		Duenhos filtrarDuenhos=new Duenhos();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("listaprovincias", provincia);
		mav.addObject("filtrarDuenhos",filtrarDuenhos );
		mav.setViewName("pagina_duenhos");
		
		return mav;
	}
	
	
	@GetMapping("/buscarDuenhos")
	public ModelAndView busqueda(@Valid @ModelAttribute("filtrarDuenhos") Duenhos filtro) {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		System.out.println(filtro);
		String pr=filtro.getProvincia();
		String usu=filtro.getUsuario();
		String nomb=filtro.getNombre();
	
		/*if(pr==null) {
			pr="%";
			System.out.println(pr);
		}
		
		if(usu==null) {
			usu="%";
			System.out.println(usu);
		}
		if(nomb==null) {
			nomb="%";
			System.out.println(nomb);
		}*/
		
			System.out.println(pr + " " + usu + " " + nomb); 
		List<DuenhoBD> listaDuenhos = (List<DuenhoBD>)duenhoDAO.lista(pr, usu, nomb);
		System.out.println(listaDuenhos);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.addObject("duenhos",listaDuenhos);
		mav.setViewName("pagina_duenhos");
		
		
		return mav;
		
	}
	
	@GetMapping("/registrarCazador")
	public ModelAndView registrarCazadores() {
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("registro_duenho");
		mav.addObject("duenhoregistro", new Duenhos());
		mav.addObject("listaprovincias", provincia);

		
		
		return mav;
		
		
		
	}
	
	@PostMapping("/guardarDuenho")
	public ModelAndView guardarDuenhos(
			@Valid @ModelAttribute("duenhoregistro") Duenhos duenhoregistro,
								Errors errores) {
		Rol rol=new Rol();
		rol=rolDAO.buscarRol("cazador/dueño");
		
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
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("editar_duenho");
		mav.addObject("duenhoEditado", duenho);
		mav.addObject("listaprovincias", provincia);
	
		
		return mav;
	}
	
	@PostMapping("/duenhoEditado")
	public ModelAndView duenhoEditado(
			@Valid @ModelAttribute("duenhoEditado") DuenhoBD duenho) {
		
		System.out.println(duenho);
		
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		duenho.setContrasenha(passwordEncoder.encode(duenho.getPassword()));
		
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
