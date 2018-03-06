package com.social.servicios;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import com.social.entidades.Usuario;

@Service
public class InsertSampleDataService {

	@Autowired
	private UsuarioService UsuariosService;

	@PostConstruct
	public void init() 
	{
		Usuario Usuario1 = new Usuario("99999990A", "Pedro", "Díaz");
		Usuario1.setPassword("123456");
		Usuario Usuario2 = new Usuario("99999991B", "Lucas", "Núñez");
		Usuario2.setPassword("123456");
		Usuario Usuario3 = new Usuario("99999992C", "María", "Rodríguez");
		Usuario3.setPassword("123456");
		Usuario Usuario4 = new Usuario("99999993D", "Marta", "Almonte");
		Usuario4.setPassword("123456");
		Usuario Usuario5 = new Usuario("99999977E", "Pelayo", "Valdes");
		Usuario5.setPassword("123456");
		Usuario Usuario6 = new Usuario("99999988F", "Edward", "Núñez");
		Usuario6.setPassword("123456");

		UsuariosService.addUsuario(Usuario1);
		UsuariosService.addUsuario(Usuario2);
		UsuariosService.addUsuario(Usuario3);
		UsuariosService.addUsuario(Usuario4);
		UsuariosService.addUsuario(Usuario5);
		UsuariosService.addUsuario(Usuario6);
	}

}
