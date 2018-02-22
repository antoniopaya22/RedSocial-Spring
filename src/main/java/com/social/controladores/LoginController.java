/**
 * 
 */
package com.social.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.entidades.Usuario;
import com.social.servicios.SecurityService;
import com.social.servicios.UsuarioService;

/**
 * <h1>Login Controller</h1> Controlador que se encarga de dar respuesta a las
 * peticiones de Login, Register, Olvide mi contraseña, o parecidos.
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private SecurityService securityService;

	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registro() {
		return "/login/registro";
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registro(@ModelAttribute("usuario") Usuario usuario,Model model) {
		usuarioService.addUsuario(usuario);
		securityService.autoLogin(usuario.getUsername(), usuario.getPasswordConfirm());
		return "redirect:panel";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "/login/login";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "/login/login";
	}

}
