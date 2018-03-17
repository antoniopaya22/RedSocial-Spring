/**
 * 
 */
package com.social.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.entidades.Comentario;
import com.social.entidades.Publicacion;
import com.social.entidades.Usuario;
import com.social.servicios.ComentarioService;
import com.social.servicios.PublicacionService;
import com.social.servicios.UsuarioService;

/**
 * <h1>Comentarios Controller</h1> Controlador que se encarga de dar respuesta a las
 * peticiones relacionadas con comentarios.
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Controller
public class ComentariosController {

	@Autowired
	private PublicacionService postService;
	@Autowired
	private UsuarioService userService;
	@Autowired
	private ComentarioService comService;

	@RequestMapping(value="/post/comentarios/{id}", method = RequestMethod.GET)
	public String listComentariosPost(Model modelo,@PathVariable Long id,Pageable pageable) {
		Publicacion post = postService.getPublicacion(id);
		Page<Comentario> comentarios = comService.findAllByPost(pageable, id);
		
		modelo.addAttribute("post", post);
		modelo.addAttribute("page",comentarios);
		modelo.addAttribute("listComent", comentarios.getContent());
		modelo.addAttribute("usuarioActivo",userService.getUsuarioActivo());
		return "post/comentarios";
	}
	
	@RequestMapping(value="/post/comentario/add/{id}",  method=RequestMethod.POST)
	public String addComentario(Model modelo,@PathVariable Long id,@ModelAttribute Comentario comentario,Pageable pageable) {
		Publicacion post = postService.getPublicacion(id);
		Comentario com = new Comentario();
		Usuario activo = userService.getUsuarioActivo();
		
		com.setAutor(activo);
		com.setTitulo(comentario.getTitulo());
		com.setContenido(comentario.getContenido());
		com.setFecha(new Date());
		com.setPost(post);
		
		post.addComentario(com);
		activo.addComentario(com);
		comService.addComentario(com);
		
		Page<Comentario> comentarios = comService.findAllByPost(pageable, id);
		modelo.addAttribute("post", post);
		modelo.addAttribute("page",comentarios);
		modelo.addAttribute("listComent", comentarios.getContent());
		modelo.addAttribute("usuarioActivo",userService.getUsuarioActivo());
		return "redirect:/post/comentarios/"+id;
	}
}
