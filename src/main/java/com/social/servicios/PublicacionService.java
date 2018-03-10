/**
 * 
 */
package com.social.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public Page<Publicacion> getPublicaciones(Pageable pageable) {
		Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);
		return publicaciones;
	}

	public Publicacion getPublicacion(Long id) {
		return publicacionRepository.findOne(id);
	}

	public void addPublicacion(Publicacion post) {
		publicacionRepository.save(post);
		log.trace("Añadida la publicacion: "+post);
	}

	public void deletePublicacion(Long id) {
		publicacionRepository.delete(id);
		log.trace("Eliminada la publicacion: "+this.getPublicacion(id));
	}

	public Page<Publicacion> buscarPostPorTituloYContenido(Pageable pageable, String searchText) {
		Page<Publicacion> publicacion = new PageImpl<Publicacion>(new LinkedList<Publicacion>());
		
		searchText = "%"+searchText+"%";
		
		publicacion = publicacionRepository.buscarPostPorTituloYContenido(pageable, searchText);
	
		return publicacion;
	}
	
	public String addImagen(MultipartFile imagen,Publicacion post) {
		String fileName = post.getId()+".png";
		try {
			InputStream is = imagen.getInputStream();
			Files.copy(is, Paths.get("src/main/resources/static/img/post/"+fileName), StandardCopyOption.REPLACE_EXISTING);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
