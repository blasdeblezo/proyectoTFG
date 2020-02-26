package com.juan.vigilanciaperroscaza.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.juan.vigilanciaperroscaza.datos.duenho.Duenho;
import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoDAO;
import com.juan.vigilanciaperroscaza.datos.guardas.GuardasDAO;
import com.juan.vigilanciaperroscaza.datos.veterinarios.Veterinarios;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosDAO;


@Service
public class AutenticacionDuenho implements UserDetailsService{

	@Autowired
	private DuenhoDAO duenhoDAO;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Duenho> user = duenhoDAO.findById(username);

		if(user.isPresent()) {	 
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
		
	
	}
	
	
	

}
	
	

