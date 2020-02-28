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
import com.juan.vigilanciaperroscaza.datos.usuarios.Usuarios;
import com.juan.vigilanciaperroscaza.datos.usuarios.UsuariosDAO;
import com.juan.vigilanciaperroscaza.datos.veterinarios.Veterinarios;
import com.juan.vigilanciaperroscaza.datos.veterinarios.VeterinariosDAO;


@Service
public class AutenticacionUsuarios implements UserDetailsService{

	@Autowired
	private UsuariosDAO usuariosDAO;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuarios> user = usuariosDAO.findById(username);

		if(user.isPresent()) {	 
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
		
	
	}
	
	
	

}
	
	

