package com.juan.vigilanciaperroscaza.email;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EnviarEmail {
	
	@Autowired
	private EnvioDeEmail envioEmail;
	
	@PostMapping("/enviarMensaje/")
	public ModelAndView sendMail(){
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("paginadeinicio");
		
		
		envioEmail.sendMail("solointernet97@gmail.com","juanserantes97@gmail.com","prueba","Esto es una prueba");
        
		
		return mav;
	}

	@PostMapping("/enviarCorreo/{email")
	public ModelAndView sendMailPersonal(@PathVariable String email){
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("paginadeinicio");
		
		envioEmail.sendMail("solointernet97@gmail.com",email,"prueba","Esto es una prueba");
        
		
		return mav;
	}
}
