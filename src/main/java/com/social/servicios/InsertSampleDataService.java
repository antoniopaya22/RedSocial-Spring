package com.social.servicios;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entidades.Comentario;
import com.social.entidades.Publicacion;
import com.social.entidades.Usuario;

@Service
public class InsertSampleDataService {

	@Autowired
	private UsuarioService usuariosService;
	
	@Autowired
	private RolesService rolesService;

	@PostConstruct
	public void init() 
	{
		Usuario usuario1 = new Usuario("pedro", "Pedro", "Díaz");
		usuario1.setPassword("123456");
		usuario1.setRole(rolesService.getRoles()[0]);
		Usuario usuario2 = new Usuario("lucas", "Lucas", "Núñez");
		usuario2.setPassword("123456");
		usuario2.setRole(rolesService.getRoles()[0]);
		Usuario usuario3 = new Usuario("maria", "María", "Rodríguez");
		usuario3.setPassword("123456");
		usuario3.setRole(rolesService.getRoles()[0]);
		Usuario usuario4 = new Usuario("marta", "Marta", "Almonte");
		usuario4.setPassword("123456");
		usuario4.setRole(rolesService.getRoles()[0]);
		Usuario usuario5 = new Usuario("pelayo", "Pelayo", "Valdes");
		usuario5.setPassword("123456");
		usuario5.setRole(rolesService.getRoles()[0]);
		Usuario usuario6 = new Usuario("edward", "Edward", "Núñez");
		usuario6.setPassword("123456");
		usuario6.setRole(rolesService.getRoles()[1]);
		
		Set<Publicacion> post2 = new HashSet<Publicacion>();
		post2.add(new Publicacion(usuario2,new Date(),"El sol brilla mucho",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n" + 
						"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\r\n" + 
						"Ut enim ad minim veniam, quis tion ullamco laboris nisi ut aliquip\r\n" + 
						"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
						"voluptate velit esse cillum dolore eu fugiat nulla pariatur.\r\n" + 
						"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\r\n" + 
						"officia deserunt mollit anim id est laborum.",
						null,new HashSet<Comentario>(),new HashSet<Usuario>()));
		
		post2.add(new Publicacion(usuario2,new Date(),"Nos merecemos un 10",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n" + 
						"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\r\n" + 
						"Ut enim ad minim veniam, quis tion ullamco laboris nisi ut aliquip\r\n" + 
						"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
						"voluptate velit esse cillum dolore eu fugiat nulla pariatur.\r\n" + 
						"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\r\n" + 
						"officia deserunt mollit anim id est laborum.",
						null,new HashSet<Comentario>(),new HashSet<Usuario>()));
		
		post2.add(new Publicacion(usuario2,new Date(),"Usando bootstrap",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n" + 
						"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\r\n" + 
						"Ut enim ad minim veniam, quis tion ullamco laboris nisi ut aliquip\r\n" + 
						"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
						"voluptate velit esse cillum dolore eu fugiat nulla pariatur.\r\n" + 
						"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\r\n" + 
						"officia deserunt mollit anim id est laborum.",
						null,new HashSet<Comentario>(),new HashSet<Usuario>()));
		
		usuario2.setPost(post2);
		
		usuario3.setPost(new HashSet<Publicacion>() {
			{
				add(new Publicacion(usuario3,new Date(),"Publicacion de prueba",
						"Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n" + 
								"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\r\n" + 
								"Ut enim ad minim veniam, quis tion ullamco laboris nisi ut aliquip\r\n" + 
								"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
								"voluptate velit esse cillum dolore eu fugiat nulla pariatur.\r\n" + 
								"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\r\n" + 
								"officia deserunt mollit anim id est laborum.",
								null,new HashSet<Comentario>(),new HashSet<Usuario>()));
			}
		});
		
		
		usuario1.setPost(new HashSet<Publicacion>() {
			{
				add(new Publicacion(usuario1,new Date(),"Hoy no quiero programar",
						"Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n" + 
								"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\r\n" + 
								"Ut enim ad minim veniam, quis tion ullamco laboris nisi ut aliquip\r\n" + 
								"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
								"voluptate velit esse cillum dolore eu fugiat nulla pariatur.\r\n" + 
								"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\r\n" + 
								"officia deserunt mollit anim id est laborum.",
								null,new HashSet<Comentario>(),new HashSet<Usuario>()));
			}
		});
		
		usuario4.setPost(new HashSet<Publicacion>() {
			{
				add(new Publicacion(usuario4,new Date(),"Drop tables",
						"Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n" + 
								"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\r\n" + 
								"Ut enim ad minim veniam, quis tion ullamco laboris nisi ut aliquip\r\n" + 
								"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
								"voluptate velit esse cillum dolore eu fugiat nulla pariatur.\r\n" + 
								"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\r\n" + 
								"officia deserunt mollit anim id est laborum.",
								null,new HashSet<Comentario>(),new HashSet<Usuario>()));
			}
		});
		
		usuario1.setFoto_desc("https://ih0.redbubble.net/cover.104630.2400x600.jpg");
		
		usuariosService.addUsuario(usuario1);
		usuariosService.addUsuario(usuario2);
		usuariosService.addUsuario(usuario3);
		usuariosService.addUsuario(usuario4);
		usuariosService.addUsuario(usuario5);
		usuariosService.addUsuario(usuario6);
		
		usuario1.addAmigo(usuario2);
		usuario1.addAmigo(usuario3);
		usuario2.addAmigo(usuario1);
		usuario3.addAmigo(usuario1);
		usuario2.addAmigo(usuario3);
		usuario3.addAmigo(usuario2);
		usuario4.addAmigo(usuario5);
		usuario5.addAmigo(usuario4);
		usuario6.addAmigo(usuario5);
		usuario5.addAmigo(usuario6);
		
		usuariosService.updateUsuario(usuario1);
		usuariosService.updateUsuario(usuario2);
		usuariosService.updateUsuario(usuario3);
		usuariosService.updateUsuario(usuario4);
		usuariosService.updateUsuario(usuario5);
		usuariosService.updateUsuario(usuario6);
	}

}
