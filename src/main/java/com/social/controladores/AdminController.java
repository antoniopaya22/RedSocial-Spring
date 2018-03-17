/**
 * 
 */
package com.social.controladores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.social.entidades.Publicacion;
import com.social.entidades.Usuario;
import com.social.servicios.RolesService;
import com.social.servicios.SecurityService;
import com.social.servicios.UsuarioService;

/**
 * <h1>Login Controller</h1> Controlador que se encarga de dar respuesta a las
 * peticiones de Administrador
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Controller
public class AdminController {

	@Autowired 
	private UsuarioService usersService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/admin/list")
	public String getList(Model model, Pageable pageable, @RequestParam(value = "", required=false) String searchText)
	{	
		Page<Usuario> usuarios = new PageImpl<Usuario>(new LinkedList<Usuario>());
		Usuario usuarioActivo = usersService.getUsuarioActivo();
		List<Usuario> adminUsers = new ArrayList<Usuario>();
		
		if (searchText != null && !searchText.isEmpty()) 
		{
			adminUsers = usersService
				.buscarUsuariosPorNombreOEmail(pageable, searchText).getContent();
			
		} else 
		{
			adminUsers = usersService.getUsuarios(pageable).getContent();
		}
		adminUsers = adminUsers.stream().filter(x -> x.getId() != usuarioActivo.getId()).collect(Collectors.toList());
		usuarios = new PageImpl<Usuario>(adminUsers);
		model.addAttribute("usuarioActivo", usuarioActivo);
		model.addAttribute("userList", usuarios.getContent());
		model.addAttribute("page", usuarios);
		return "/admin/list";
		
	}
	
	@RequestMapping(value = "/admin/eliminarUsuario/{id}")
	public String deleteUser(Model model, @ModelAttribute Publicacion form, @PathVariable Long id) {
		Usuario activo = usersService.getUsuarioActivo();
		usersService.deleteUsuario(id);
		model.addAttribute("usuarioActivo", activo);
		return "redirect:/admin/list";
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "/admin/login";
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute Usuario u) {
		String username = u.getUsername();
		String passwd = u.getPassword();
		Usuario intento = usersService.getUserByUsername(username);
		if(intento == null || !intento.getRole().equals(rolesService.getRoles()[1]))
			return "redirect:/login/error";
		securityService.autoLogin(username, passwd);
		return "redirect:/admin/list";
	}



}
