package com.juan.vigilanciaperroscaza.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.juan.vigilanciaperroscaza.datos.veterinarios.Veterinarios;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosDAO;

@Service
public class AutenticacionVeterinario implements UserDetailsService{
	
	@Autowired
	private VeterinariosDAO veterinarioDAO;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Veterinarios> user=veterinarioDAO.findById(username);
		
		if(user.isPresent()) {
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
	}

}
