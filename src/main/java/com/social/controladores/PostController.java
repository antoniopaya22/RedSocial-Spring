package com.social.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.social.entidades.Publicacion;
import com.social.entidades.Usuario;
import com.social.servicios.PublicacionService;
import com.social.servicios.UsuarioService;

@Controller
public class PostController {
	@Autowired
	private PublicacionService postService;
	@Autowired
	private UsuarioService usersService;

	@RequestMapping("/post/add")
	public String addPost(Model model) {
		model.addAttribute("usuarioActivo", usersService.getUsuarioActivo());
		return "/post/crear-post";
	}

	@RequestMapping(value = "/post/add", method = RequestMethod.POST)
	public String addPost(Model model, @RequestParam("titulo") String titulo,
			@RequestParam("contenido") String contenido, @RequestParam("imagen") MultipartFile imagen) {
		Usuario activo = usersService.getUsuarioActivo();
		Publicacion post = new Publicacion();
		post.setAutor(activo);
		post.setContenido(contenido);
		post.setTitulo(titulo);
		post.setFecha(new Date());
		activo.addPost(post);
		postService.addPublicacion(post);
		usersService.addUsuario(activo);
		String rutaImagen = postService.addImagen(imagen, post);
		post.setImagen(rutaImagen);
		postService.addPublicacion(post);
		model.addAttribute("usuario", activo);
		model.addAttribute("usuarioActivo", usersService.getUsuarioActivo());
		return "redirect:/post/list";
	}

	@RequestMapping(value = "/post/list")
	public String getPostList(Model model) {
		Usuario activo = usersService.getUsuarioActivo();
		model.addAttribute("usuarioActivo", activo);
		return "post/list";
	}

	@RequestMapping(value = "/post/edit/{id}")
	public String editPost(Model model, @PathVariable Long id) {
		model.addAttribute("post", postService.getPublicacion(id));
		model.addAttribute("usuarioActivo", usersService.getUsuarioActivo());
		return "/post/editar-post";
	}

	@RequestMapping(value = "/post/edit/{id}", method = RequestMethod.POST)
	public String editPost(Model model, @ModelAttribute Publicacion form, @PathVariable Long id) {
		Usuario activo = usersService.getUsuarioActivo();
		Publicacion post = postService.getPublicacion(id);
		if (form.getTitulo() != "")
			post.setTitulo(form.getTitulo());
		if (form.getContenido() != "")
			post.setContenido(form.getContenido());

		postService.addPublicacion(post);
		model.addAttribute("usuarioActivo", activo);
		return "redirect:/post/list";
	}

	@RequestMapping(value = "/post/delete/{id}")
	public String deletePost(Model model, @ModelAttribute Publicacion form, @PathVariable Long id) {
		Usuario activo = usersService.getUsuarioActivo();
		postService.deletePublicacion(id);
		model.addAttribute("usuarioActivo", activo);
		return "redirect:/post/list";
	}
	
	@RequestMapping(value="/post/like/{id}")
	public String addLike(Model model,@PathVariable Long id){
		Publicacion post = postService.getPublicacion(id);
		Usuario activo = usersService.getUsuarioActivo();
		post.addLike(activo);
		activo.addLike(post);
		
		postService.addPublicacion(post);
		usersService.addUsuario(activo);
		model.addAttribute("usuarioActivo", activo);
		return "redirect:/";
	}
}
