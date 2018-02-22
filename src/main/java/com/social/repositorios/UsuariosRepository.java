/**
 * 
 */
package com.social.repositorios;

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
	
	Usuario findByUsername(String username);
}
