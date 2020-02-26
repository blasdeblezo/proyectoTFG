package com.juan.vigilanciaperroscaza.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.juan.vigilanciaperroscaza.servicios.AutenticacionDuenho;
import com.juan.vigilanciaperroscaza.servicios.AutenticacionGuarda;
import com.juan.vigilanciaperroscaza.servicios.AutenticacionVeterinario;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private AutenticacionDuenho autenticacionDuenho;
	 
	 @Autowired
	 private AutenticacionGuarda autenticacionGuarda;
	 
	 @Autowired
	 private AutenticacionVeterinario autenticacionVeterinario;
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        
	    	DaoAuthenticationProvider providerDuenho = new DaoAuthenticationProvider();
	        providerDuenho.setPasswordEncoder(new BCryptPasswordEncoder());
	        providerDuenho.setUserDetailsService(autenticacionDuenho);
	    	auth.authenticationProvider(providerDuenho);
	    	
	    	DaoAuthenticationProvider providerGuarda = new DaoAuthenticationProvider();
	    	providerGuarda.setPasswordEncoder(new BCryptPasswordEncoder());
	    	providerGuarda.setUserDetailsService(autenticacionGuarda);
	    	auth.authenticationProvider(providerGuarda);
	    	
	    	DaoAuthenticationProvider providerVeterinario = new DaoAuthenticationProvider();
	    	providerVeterinario.setPasswordEncoder(new BCryptPasswordEncoder());
	    	providerVeterinario.setUserDetailsService(autenticacionVeterinario);
	    	auth.authenticationProvider(providerVeterinario);
	    	
	    	
	    }   
	    
	    
}
