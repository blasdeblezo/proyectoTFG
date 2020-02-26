package com.juan.vigilanciaperroscaza.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.juan.vigilanciaperroscaza.datos.duenho.Duenho;
import com.juan.vigilanciaperroscaza.datos.guardas.Guardas;
import com.juan.vigilanciaperroscaza.datos.guardas.GuardasDAO;

@Service
public class AutenticacionGuarda implements UserDetailsService{

	@Autowired
	private GuardasDAO guardaDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Guardas> user = guardaDAO.findById(username);

		if(user.isPresent()) {	 
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
	
	}

}
