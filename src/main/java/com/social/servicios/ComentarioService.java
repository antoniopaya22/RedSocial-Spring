/**
 * 
 */
package com.social.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.social.entidades.Comentario;
import com.social.repositorios.ComentarioRepository;

/**
 * <h1>ComentarioService</h1>
 * 
 * Servicio que se encarga de realizar las operaciones con comentarios
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	public List<Comentario> getComentarios() {
		List<Comentario> comentarios = new ArrayList<Comentario>();
		comentarioRepository.findAll().forEach(comentarios::add);
		return comentarios;
	}

	public Comentario getComentario(Long id) {
		return comentarioRepository.findOne(id);
	}

	public void addComentario(Comentario Usuario) {
		comentarioRepository.save(Usuario);
	}

	public void deleteComentario(Long id) {
		comentarioRepository.delete(id);
	}
	
	public Page<Comentario> findAllByPost(Pageable pageable,Long id){
		return comentarioRepository.findAllByPost(pageable, id);
	}
}
