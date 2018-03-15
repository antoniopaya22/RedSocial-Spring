package com.social.servicios;

import org.springframework.stereotype.Service;

/**
 * @author Pablo Díaz Rancaño
 * @author Antonio Paya Gonzalez
 *
 */
@Service
public class RolesService {
	String[] roles = {"ROLE_USUARIO","ROLE_ADMIN"};
	
	public String[] getRoles() {
		return roles;
	}
}
