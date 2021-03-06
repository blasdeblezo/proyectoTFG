package com.juan.vigilanciaperroscaza.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosBD;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosDAO;


@Service
public class AutentificacionVeterinarios implements UserDetailsService{
	
	@Autowired
	private VeterinariosDAO veterinariosDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<VeterinariosBD> user = veterinariosDAO.findById(username);
		
		if(user.isPresent()) {
			
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
	}

}
