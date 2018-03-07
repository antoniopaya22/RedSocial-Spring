/**
 * 
 */
package com.social.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.servicios.PublicacionService;
import com.social.servicios.UsuarioService;

/**
 * <h1>Panel Controller</h1> 
 * 
 * Controlador que se encarga de dar respuesta a las
 * peticiones correspondientes a el panel de la aplicacion
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Controller
public class PanelController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PublicacionService postService;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("usuarioActivo", usuarioService.getUsuarioActivo());
		model.addAttribute("listPost",postService.getPublicaciones());
		return "/panel";
	}

}
