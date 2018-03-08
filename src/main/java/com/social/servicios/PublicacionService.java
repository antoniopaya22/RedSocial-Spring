/**
 * 
 */
package com.social.servicios;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.social.entidades.Publicacion;
import com.social.entidades.Usuario;
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

	public Page<Publicacion> getPublicaciones(Pageable pageable) {
		Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);
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

	public Page<Publicacion> buscarPostPorTituloYContenido(Pageable pageable, String searchText) {
		Page<Publicacion> publicacion = new PageImpl<Publicacion>(new LinkedList<Publicacion>());
		
		searchText = "%"+searchText+"%";
		
		publicacion = publicacionRepository.buscarPostPorTituloYContenido(pageable, searchText);
	
		return publicacion;
	}
}
