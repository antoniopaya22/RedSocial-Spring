/**
 * 
 */
package com.social.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Comentario;

/**
 * <h1>ComentarioRepository</h1>
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
public interface ComentarioRepository extends CrudRepository<Comentario, Long>{
	
	@Query("SELECT u FROM Comentario u WHERE u.post.id = ?1")
	Page<Comentario> findAllByPost(Pageable pageable,Long id);
}
