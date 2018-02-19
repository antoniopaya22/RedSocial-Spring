/**
 * 
 */
package com.social.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Comentario;

/**
 * <h1>ComentarioRepository</h1>
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
public interface ComentarioRepository extends CrudRepository<Comentario, Long>{}
