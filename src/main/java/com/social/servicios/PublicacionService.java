/**
 * 
 */
package com.social.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.entidades.Publicacion;
import com.social.repositorios.PublicacionRepository;

/**
 * <h1>PublicacionService</h1>
 * 
 * Servicio que se encarga de realizar las operaciones con publicaciones
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Service
public class PublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;

	public List<Publicacion> getPublicaciones() {
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicacionRepository.findAll().forEach(publicaciones::add);
		return publicaciones;
	}

	public Publicacion getPublicacion(Long id) {
		return publicacionRepository.findOne(id);
	}

	public void addPublicacion(Publicacion Usuario) {
		publicacionRepository.save(Usuario);
	}

	public void deletePublicacion(Long id) {
		publicacionRepository.delete(id);
	}
}
