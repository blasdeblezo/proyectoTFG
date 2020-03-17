package com.juan.vigilanciaperroscaza.seguridad;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.juan.vigilanciaperroscaza.servicios.AutenticacionDuenhos;
import com.juan.vigilanciaperroscaza.servicios.AutentificacionGuardas;
import com.juan.vigilanciaperroscaza.servicios.AutentificacionVeterinarios;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private AutenticacionDuenhos autenticacionDuenhos;
	 
	 @Autowired
	 private AutentificacionVeterinarios atentificacionVeterinarios;
	 
	 @Autowired
	 private AutentificacionGuardas autentificacionGuardas;
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        
		DaoAuthenticationProvider providerDuenho = new DaoAuthenticationProvider();
		providerDuenho.setPasswordEncoder(new BCryptPasswordEncoder());
		providerDuenho.setUserDetailsService(autenticacionDuenhos);

		auth.authenticationProvider(providerDuenho);

		DaoAuthenticationProvider providerVeterinario = new DaoAuthenticationProvider();
		providerVeterinario.setPasswordEncoder(new BCryptPasswordEncoder());
		providerVeterinario.setUserDetailsService(atentificacionVeterinarios);
		auth.authenticationProvider(providerVeterinario);

		DaoAuthenticationProvider providerGuerdas = new DaoAuthenticationProvider();
		providerGuerdas.setPasswordEncoder(new BCryptPasswordEncoder());
		providerGuerdas.setUserDetailsService(autentificacionGuardas);
		auth.authenticationProvider(providerGuerdas);
	    	
	    	
	    	
	    	
	    	
	    }   
	    
	    
}
