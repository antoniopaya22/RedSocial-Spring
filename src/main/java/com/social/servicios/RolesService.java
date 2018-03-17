package com.social.servicios;

import org.springframework.stereotype.Service;

/**
 * <h1>RolesService</h1>
 * Servicio encargado de proporcionar los roles de la aplicacion
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Service
public class RolesService {
	String[] roles = {"ROLE_USUARIO","ROLE_ADMIN"};
	
	public String[] getRoles() {
		return roles;
	}
}
