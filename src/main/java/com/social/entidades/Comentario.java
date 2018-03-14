/**
 * 
 */
package com.social.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <h1>Comentario</h1> Modelo que representa un comentario de un usuario en una
 * publicacion
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String contenido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Publicacion post;
	
	

	public Comentario() {}

	/**
	 * Constructor principal de la clase
	 * @param titulo
	 * @param contenido
	 * @param fecha
	 * @param autor
	 * @param post
	 */
	public Comentario(String titulo, String contenido, Date fecha, Usuario autor, Publicacion post) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
		this.autor = autor;
		this.post = post;
	}



	// ===================GETTERS===================
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the autor
	 */
	public Usuario getAutor() {
		return autor;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the post
	 */
	public Publicacion getPost() {
		return post;
	}
	
	//===================SETTERS===================

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Publicacion post) {
		this.post = post;
	}

	

	
	//===================toString===================
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", autor=" + autor + ", fecha=" + fecha + ", titulo=" + titulo + ", contenido="
				+ contenido + ", post=" + post + "]";
	}

}
