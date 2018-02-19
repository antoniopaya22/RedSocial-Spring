/**
 * 
 */
package com.social.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Publicacion;

/**
 * <h1>PublicacionRepository</h1>
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
public interface PublicacionRepository extends CrudRepository<Publicacion, Long>{}
