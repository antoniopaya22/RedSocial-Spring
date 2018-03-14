/**
 * 
 */
package com.social.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Publicacion;

/**
 * <h1>PublicacionRepository</h1>
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
public interface PublicacionRepository extends CrudRepository<Publicacion, Long>{
	
	Page<Publicacion> findAll(Pageable pageable);

	@Query("SELECT u FROM Publicacion u WHERE (LOWER(u.titulo) LIKE LOWER(?1) OR LOWER(u.contenido) LIKE LOWER(?1))")
	Page<Publicacion> buscarPostPorTituloYContenido(Pageable pageable, String searchText);

}
