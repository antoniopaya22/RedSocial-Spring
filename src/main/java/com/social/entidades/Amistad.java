package com.social.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amistad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long usuario1_id;	
	private long usuario2_id;
	
	public Amistad() {}
	
	public Amistad(long id_us1, long id_us2)
	{
		this.usuario1_id = id_us1;
		this.usuario2_id = id_us2;
	}

	public long getUsuario1_id() {
		return usuario1_id;
	}

	public void setUsuario1_id(long usuario1_id) {
		this.usuario1_id = usuario1_id;
	}

	public long getUsuario2_id() {
		return usuario2_id;
	}

	public void setUsuario2_id(long usuario2_id) {
		this.usuario2_id = usuario2_id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Amistad [id=" + id + ", id_usuario1=" + usuario1_id + ", id_usuario2=" + usuario2_id + "]";
	}
	
}
