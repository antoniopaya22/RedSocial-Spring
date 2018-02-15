/**
 * 
 */
package com.social.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h1>Login Controller</h1>
 * Controlador que se encarga de dar respuesta
 * a las peticiones de Login, Register, Olvide mi contraseña, o parecidos.
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/registro")
	public String registro() {
		return "registro";
	}

}
