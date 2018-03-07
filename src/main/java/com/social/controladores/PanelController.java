/**
 * 
 */
package com.social.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String panel() {
		return "/panel";
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "/panel";
	}

}
