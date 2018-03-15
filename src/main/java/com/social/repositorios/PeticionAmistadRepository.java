package com.social.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Amistad;
import com.social.entidades.Usuario;

public interface PeticionAmistadRepository extends CrudRepository<Amistad, Long>
{
	@Transactional
	@Modifying
	@Query("DELETE FROM Amistad a WHERE a.usuario1 = ?1 AND a.usuario2= ?2")
	void delete(long id_u1, long id_u2);
	
	@Query("SELECT u FROM Usuario u WHERE u.id IN( "
			+ "SELECT a.usuario1 FROM Amistad a WHERE a.usuario2 = ?1)")
	Page<Usuario> findAllByUsuario2(Pageable pageable, long id_u2);
	
	@Query("SELECT a FROM Amistad a WHERE a.usuario1 = ?1 AND a.usuario2 = ?2")
	List<Amistad> findPeticiones(long id_u1, long id_u2);
}
