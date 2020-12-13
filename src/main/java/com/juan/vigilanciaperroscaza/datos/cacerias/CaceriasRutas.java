package com.juan.vigilanciaperroscaza.datos.cacerias;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSInput;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoDAO;
import com.juan.vigilanciaperroscaza.datos.guardas.GuardasBD;
import com.juan.vigilanciaperroscaza.datos.guardas.GuardasDAO;
import com.juan.vigilanciaperroscaza.datos.perro.PerrosBD;
import com.juan.vigilanciaperroscaza.datos.perro.PerrosDAO;
import com.juan.vigilanciaperroscaza.datos.provincias.Provincias;
import com.juan.vigilanciaperroscaza.datos.provincias.ProvinciasDAO;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;

@Controller
public class CaceriasRutas {

	@Autowired
	private CaceriasDAO caceriasDAO;
	@Autowired
	private ProvinciasDAO provinciasDAO;
	@Autowired
	private DuenhoDAO duenhoDAO;
	@Autowired
	private PerrosDAO perrosDAO;
	@Autowired
	private GuardasDAO guardasDAO;
	
	@GetMapping("/listacacerias")
	public ModelAndView listacacerias() {
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.addObject("filtrarCacerias", new CaceriasBD());
		System.out.println(provincia);
		mav.setViewName("pagina_cacerias");
		
		return mav;
		
	
	}
	
	@GetMapping("/buscarCacerias")
	public ModelAndView buscarCacerias(@Valid @ModelAttribute("filtrarCacerias") Cacerias filtro) {
		
		System.out.println(filtro);
		String pr=filtro.getProvincia();
		Long id= filtro.getId_caceria();
		
		String fc=filtro.getFecha();
		
		if(pr==null) {
			pr="%";
		}
		
		if(fc==null) {
			fc="%";
		}
		
		List<Provincias> provincia=(List<Provincias>)provinciasDAO.findAll();
		List<CaceriasBD>listaCacerias=(List<CaceriasBD>)caceriasDAO.lista(pr,fc);
		System.out.println(listaCacerias);
		ModelAndView mav=new ModelAndView();
		mav.addObject("listaprovincias", provincia);
		mav.addObject("caceria", new CaceriasBD());
		mav.addObject("cacerias", listaCacerias);
		
		
		
		mav.setViewName("pagina_cacerias");
		
		return mav;
	}
	
	@GetMapping("/registrarCaceria")
	public ModelAndView registroCacerias() {
		List<Provincias> provincia=(List<Provincias>) provinciasDAO.findAll();
		List<DuenhoBD> listaduenhos = (List<DuenhoBD>)duenhoDAO.findAll();
		List<PerrosBD> listaPerros = (List<PerrosBD>)perrosDAO.findAll(); 
		List<GuardasBD> listaGuardas= (List<GuardasBD>)guardasDAO.findAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("provincias", provincia);
		mav.addObject("listaDuenhos", listaduenhos);
		mav.addObject("listaPerros", listaPerros);
		mav.addObject("listaGuardas", listaGuardas);
		mav.addObject("caceriaRegistrada", new CaceriasBD());
		mav.setViewName("registro_caceria");
		
		return mav;
	}
	
	@GetMapping("/fichaCaceria/{id}")
	public ModelAndView fichaCaceria(
								@Valid @PathVariable Long id) {
		
		ModelAndView mav= new ModelAndView();
		CaceriasBD  caceria = caceriasDAO.caceria(id);
		mav.addObject("caceria", caceria);
		System.out.println(caceria);
		mav.setViewName("ficha_caceria");
		
		return mav;
		
	}
	
	@PostMapping("/guardarCaceria")
	public ModelAndView guardarCaceria(@Valid @ModelAttribute("caceriaRegistrada") CaceriasBD caceriaregistro,
									Errors errores) {
		
		ModelAndView mav = new ModelAndView();
		CaceriasBD caceria = GenerarCaceria(caceriaregistro);
		
		caceriasDAO.save(caceria);
		
		mav.setViewName("paginadeinicio");
	
		return mav;
		
		
	}
	
	@GetMapping("/eliminarCaceria/{caceria}")
	public ModelAndView eliminarCaceria(@PathVariable Long caceria) {
		caceriasDAO.deleteById(caceria);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pagina_cacerias");
		
		return mav;
		
		
	}
	
	public CaceriasBD GenerarCaceria(@Valid  CaceriasBD caceriaregistro) {
		CaceriasBD caceria = new CaceriasBD();
		
		caceria.setId_caceria(caceriaregistro.getId_caceria());
		caceria.setProvincia(caceriaregistro.getProvincia());
		caceria.setFecha(caceriaregistro.getFecha());
		caceria.setNumero_perros(caceriaregistro.getNumero_perros());
		caceria.setNumero_cazadores(caceriaregistro.getNumero_cazadores());
		caceria.setGuardas(caceriaregistro.getGuardas());
		caceria.setListaDuenhos(caceriaregistro.getListaDuenhos());
		
		return caceria;
	}

}
