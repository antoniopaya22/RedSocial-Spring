package com.social.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.entidades.Amistad;

public interface PeticionAmistadRepository extends CrudRepository<Amistad, Long>
{
	@Query("DELETE FROM Amistad a WHERE a.usuario1_id = ?1 AND a.usuario2_id = ?2")
	void delete(long id_u1, long id_u2);
}
