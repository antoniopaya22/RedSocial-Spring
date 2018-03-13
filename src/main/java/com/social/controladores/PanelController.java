/**
 * 
 */
package com.social.controladores;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.social.entidades.Publicacion;
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
	public String home(Model model,Pageable pageable,@RequestParam(value = "", required=false) String searchText) {
		
		Page<Publicacion> publicaciones = new PageImpl<Publicacion>(new LinkedList<Publicacion>());
		
		if (searchText != null && !searchText.isEmpty()) 
		{
			publicaciones = postService.buscarPostPorTituloYContenido(pageable, searchText);
			
		} else 
		{
			publicaciones = postService.getPublicacionesAmigos(pageable,usuarioService.getUsuarioActivo());
		}
		
		model.addAttribute("usuarioActivo", usuarioService.getUsuarioActivo());
		model.addAttribute("listPost",publicaciones.getContent());
		model.addAttribute("page", publicaciones);
		return "/panel";
	}

}
