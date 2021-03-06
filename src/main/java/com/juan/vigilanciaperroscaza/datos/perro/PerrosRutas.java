package com.juan.vigilanciaperroscaza.datos.perro;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoDAO;
import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;
import com.juan.vigilanciaperroscaza.datos.revisiones.RevisionesBD;
import com.juan.vigilanciaperroscaza.datos.revisiones.RevisionesDAO;

import ch.qos.logback.core.rolling.helper.RenameUtil;

@Controller
public class PerrosRutas {

	@Autowired
	private PerrosDAO perrosDAO;
	
	@Autowired
	private DuenhoDAO duenhoDAO;
	
	@Autowired
	private ProvinciasDAO provinciasDAO;
	
	@Autowired
	private RevisionesDAO revisionesDAO;
	
	@GetMapping("/listaperros")
	public ModelAndView listaperros() {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		PerrosBD filtro = new PerrosBD();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.addObject("filterPerros", filtro);
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
		
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		/*String pr= filtro.getDuenho().getUsuario();
		String id_usuario= filtro.getDuenho().getUsuario();
		String id_perro= filtro.getId_perro();
		
		if(pr==null) {
			pr="%";
			System.out.println(pr);
		}
		
		if(id_usuario==null) {
			id_usuario="%";
			System.out.println(id_usuario);
			
		}
		if(id_perro==null) {
			id_perro="%";
			System.out.println(id_perro);
		}*/
		
		//List<PerrosBD> listaPerros=(List<PerrosBD>) perrosDAO.listaPerros(id_perro, id_usuario, pr);
		List<PerrosBD> listaPerros=(List<PerrosBD>) perrosDAO.findAll();
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
		List<RevisionesBD> listaRevisiones=(List<RevisionesBD>) revisionesDAO.revisiones(id);
		ModelAndView mav=new ModelAndView();
		
		System.out.println(perro);
		mav.addObject("perro", perro);
		mav.addObject("listaRevisiones", listaRevisiones);
		mav.setViewName("ficha_perro");
		
		return mav;
	}
	
	@GetMapping("/revision/{id}")
	public ModelAndView revisionPerro(@PathVariable Long id) {
		
		
		ModelAndView mav = new ModelAndView();
		
		RevisionesBD revision = revisionesDAO.revisionPerro(id);
		mav.addObject("revision", revision);
		System.out.println(revision);
		mav.setViewName("revision_perro");
		return mav;
	}
	
	@GetMapping("/editarPerro/{id}")
	public ModelAndView editarPerro(@PathVariable String id) {
		
		PerrosBD perro=perrosDAO.ficha(id);
		List<DuenhoBD> listaDuenhos = (List<DuenhoBD>)duenhoDAO.findAll();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("perroEditado", perro);
		mav.addObject("listaduenhos", listaDuenhos);
		mav.setViewName("editar_perro");
		
		return mav;
		
	}
	
	@PostMapping("/perroEditado")
	public ModelAndView perroEditado(@Valid @ModelAttribute("perroEditado") PerrosBD perro) {
		
		System.out.println(perro);
		
		ModelAndView mav=new ModelAndView();
		perrosDAO.save(perro);
		mav.setViewName("pagina_perros");
		
		
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
