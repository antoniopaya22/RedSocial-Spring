/**
 * 
 */
package com.social.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <h1>Publicacion</h1> Modelo que representa una publicacion de un usuario
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Entity
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@Column(length=16777216)
	private String contenido;
	private String imagen;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@ManyToOne
	private Usuario autor;
	@OneToMany(mappedBy = "post")
	private Set<Comentario> comentarios = new HashSet<>();
	@ManyToMany(mappedBy = "likes_dados")
	private Set<Usuario> likes = new HashSet<>();

	public Publicacion() {}

	
	
	/**
	 * Constructor principal de la clase
	 * @param autor
	 * @param fecha
	 * @param titulo
	 * @param contenido
	 * @param imagen
	 * @param comentarios
	 * @param likes
	 */
	public Publicacion(Usuario autor, Date fecha, String titulo, String contenido, String imagen,
			Set<Comentario> comentarios, Set<Usuario> likes) {
		super();
		this.autor = autor;
		this.fecha = fecha;
		this.titulo = titulo;
		this.contenido = contenido;
		this.imagen = imagen;
		this.comentarios = comentarios;
		this.likes = likes;
	}



	//===================GETTERS===================
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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @return the comentarios
	 */
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @return the likes
	 */
	public Set<Usuario> getLikes() {
		return likes;
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
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Set<Usuario> likes) {
		this.likes = likes;
	}
	
	//===================Hash Code & Equals===================

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//===================ToString===================
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", autor=" + autor + ", fecha=" + fecha + ", titulo=" + titulo + ", contenido="
				+ contenido + ", imagen=" + imagen + ", comentarios=" + comentarios + ", likes=" + likes + "]";
	}

	
}
