/**
 * 
 */
package com.social.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.entidades.Usuario;
import com.social.servicios.SecurityService;
import com.social.servicios.UsuarioService;
import com.social.validadores.RegistroValidator;

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
	
	@Autowired
	private RegistroValidator registroValidator;

	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login/registro";
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registro(@ModelAttribute @Validated Usuario usuario,BindingResult result,Model model) {
		registroValidator.validate(usuario, result);
		if(result.hasErrors()) {
			return "login/registro";
		}
		usuarioService.addNuevoUsuario(usuario);
		securityService.autoLogin(usuario.getUsername(), usuario.getPasswordConfirm());
		model.addAttribute("usuarioActivo", usuarioService.getUsuarioActivo());
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "/login/login";
	}


	@RequestMapping(value = "/login/error", method = RequestMethod.GET)
	public String loginError(Model model) {
		return "/login/error";
	}
}
