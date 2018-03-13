package com.social.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.social.servicios.UsuarioService;

@Entity
public class Amistad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long usuario1;	
	private long usuario2;
	
	public Amistad() {}
	
	public Amistad(long id_us1, long id_us2)
	{
		this.usuario1 = id_us1;
		this.usuario2 = id_us2;
	}

	public long getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(long usuario1_id) {
		this.usuario1 = usuario1_id;
	}

	public long getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(long usuario2_id) {
		this.usuario2 = usuario2_id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Amistad [id=" + id + ", id_usuario1=" + usuario1 + ", id_usuario2=" + usuario2 + "]";
	}
	
}
