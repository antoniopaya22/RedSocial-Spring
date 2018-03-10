/**
 * 
 */
package com.social.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Usuario;

/**
 * <h1>UsuariosRepository</h1>
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
public interface UsuariosRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE (LOWER(u.nombre) LIKE LOWER(?1) OR LOWER(u.email) LIKE LOWER(?1))")
	Page<Usuario> buscarPorNombreOEmail(Pageable pageable, String seachtext);
	
	Usuario findByUsername(String username);

	Usuario findByEmail(String email);
	
	Page<Usuario> findAll(Pageable pageable);
	
	@Query("SELECT a.usuario2_id FROM Amistad a WHERE a.usuario1_id = ?1")
	List<Long> findPeticionesEnviadas(long id_usuario);
}
