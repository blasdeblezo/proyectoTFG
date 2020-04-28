package com.juan.vigilanciaperroscaza.servicios;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoBD;
import com.juan.vigilanciaperroscaza.datos.duenho.DuenhoDAO;


@Service
@Transactional
public class AutenticacionDuenhos implements UserDetailsService{
	
	@Autowired
	private DuenhoDAO duenhoDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<DuenhoBD> user = duenhoDAO.findById(username);
		
		if(user.isPresent()) {
			
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
	}
	

}
