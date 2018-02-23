/**
 * 
 */
package com.social.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.social.entidades.Usuario;
import com.social.repositorios.UsuariosRepository;

/**
 * <h1>UsuarioService</h1>
 * 
 * Servicio que se encarga de realizar las operaciones con usuarios
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuariosRepository usuariosRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuariosRepository.findAll().forEach(usuarios::add);
		return usuarios;
	}

	public Usuario getUsuario(Long id) {
		return usuariosRepository.findOne(id);
	}

	public void addUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuariosRepository.save(usuario);
	}

	public void deleteUsuario(Long id) {
		usuariosRepository.delete(id);
	}

	public Usuario getUserByUsername(String username) {
		return usuariosRepository.findByUsername(username);
	}

	public Object getUserByEmail(String email) {
		return usuariosRepository.findByEmail(email);
	}

}
