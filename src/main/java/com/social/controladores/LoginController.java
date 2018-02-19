/**
 * 
 */
package com.social.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.entidades.Usuario;
import com.social.servicios.UsuarioService;

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
	
	private UsuarioService usuarioService;
	
	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping("/user/login")
	public String loginUsuario(@PathVariable String usuario,@PathVariable String password) {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		Usuario a = usuarios.stream().filter(x -> x.getUsername().equals(usuario) && x.getPassword().equals(password))
		.findFirst().get();
		return a==null?"redirect:panel":"redirect:login/registro";
	}
	
	@RequestMapping("/registro")
	public String registro() {
		return "login/registro";
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registrarUsuario(@PathVariable String username,@PathVariable String password,@PathVariable String email) {
		Usuario user = new Usuario();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		usuarioService.addUsuario(user);
		return "redirect:/login";
	}

}
