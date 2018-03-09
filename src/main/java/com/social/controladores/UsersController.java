package com.social.controladores;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.social.entidades.Usuario;
import com.social.servicios.UsuarioService;

@Controller
public class UsersController 
{
	@Autowired 
	private UsuarioService usersService;
	
	@RequestMapping("/users/lista-usuarios")
	public String getList(Model model, Pageable pageable, @RequestParam(value = "", required=false) String searchText)
	{	
		Page<Usuario> usuarios = new PageImpl<Usuario>(new LinkedList<Usuario>());
		Usuario usuarioActivo = usersService.getUsuarioActivo();
		
		if (searchText != null && !searchText.isEmpty()) 
		{
			usuarios = usersService
				.buscarUsuariosPorNombreOEmail(pageable, searchText);
			
		} else 
		{
			usuarios = usersService.getUsuarios(pageable);
		}
		model.addAttribute("usuarioActivo", usuarioActivo);
		model.addAttribute("userList", usuarios.getContent());
		model.addAttribute("usuariosPeticionesEnviadas", usersService.getPeticionesEnviadas( usuarioActivo ));
		model.addAttribute("page", usuarios);
		return "/users/lista-usuarios";
		
	}
	
	@RequestMapping("/users/perfil/{username}")
	public String getPerfil(Model model,@PathVariable String username)
	{	
		model.addAttribute("usuario", usersService.getUserByUsername(username));
		model.addAttribute("usuarioActivo", usersService.getUsuarioActivo());
		return "/users/perfil";
		
	}
	
	@RequestMapping(value="/user/edit", method=RequestMethod.POST)
	public String editUser(Model model,  @ModelAttribute Usuario form)
	{	
		Usuario activo = usersService.getUsuarioActivo();
		if(form.getNombre() != "")activo.setNombre(form.getNombre());
		if(form.getApellidos() != "")activo.setApellidos(form.getApellidos());
		if(form.getEmail() != "")activo.setEmail(form.getEmail());
		if(form.getDescripcion() != "")activo.setDescripcion(form.getDescripcion());
		
		usersService.addUsuario(activo);
		model.addAttribute("usuario", activo);
		model.addAttribute("usuarioActivo", activo);
		return "/users/perfil";
		
	}
	
	@RequestMapping("/users/lista-amigos")
	public String getAmigos(Model model, Pageable pageable, @RequestParam(value = "", required=false) String searchText)
	{	
		Page<Usuario> usuarios = new PageImpl<Usuario>(new LinkedList<Usuario>());
		
		if (searchText != null && !searchText.isEmpty()) 
		{
			usuarios = usersService
				.buscarUsuariosPorNombreOEmail(pageable, searchText);
			
		} else 
		{
			usuarios = usersService.getUsuariosAmigos(pageable,usersService.getUsuarioActivo());
		}
		model.addAttribute("usuarioActivo", usersService.getUsuarioActivo());
		model.addAttribute("userList", usuarios.getContent());
		model.addAttribute("page", usuarios);
		return "/users/lista-amigos";
		
	}
	
	
	@RequestMapping("/users/enviarAmistad/{id}")
	public String addPeticionAmistad(Model model, @PathVariable long id, Pageable pageable, @RequestParam(value = "", required=false) String searchText)
	{	
		Usuario u1 = usersService.getUsuarioActivo();
		Usuario u2 = usersService.getUsuario( id );
		usersService.addPeticionAmistad(u1, u2);
		
		Page<Usuario> usuarios = new PageImpl<Usuario>(new LinkedList<Usuario>());
		usuarios = usersService
				.buscarUsuariosPorNombreOEmail(pageable, searchText);
		
		model.addAttribute("usuarioActivo", u1);
		model.addAttribute("userList", usuarios.getContent());
		model.addAttribute("page", usuarios);
		return "redirect:/users/lista-usuarios";
	}
	
}
