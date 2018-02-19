/**
 * 
 */
package com.social.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * <h1>Usuario</h1> Modelo que representa a un usuario del sistema
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String nombre;
	private String apellidos;
	private String descripcion;
	private String foto_perfil;
	private String foto_desc;

	@ManyToMany
	private Set<Usuario> amigos = new HashSet<>();
	@OneToMany(mappedBy = "autor")
	private Set<Publicacion> post = new HashSet<>();
	@OneToMany(mappedBy = "autor")
	private Set<Comentario> comentarios = new HashSet<>();
	@ManyToMany
	private Set<Publicacion> likes_dados = new HashSet<>();
	


	public Usuario() {}
	
	

	/**
	 * Constructor principal de la clase usuario
	 * @param username
	 * @param password
	 * @param email
	 * @param nombre
	 * @param apellidos
	 * @param descripcion
	 * @param foto_perfil
	 * @param foto_desc
	 * @param amigos
	 * @param post
	 * @param comentarios
	 */
	public Usuario(String username, String password, String email, String nombre, String apellidos, String descripcion,
			String foto_perfil, String foto_desc, Set<Usuario> amigos, Set<Publicacion> post,
			Set<Comentario> comentarios,Set<Publicacion> likes) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.foto_perfil = foto_perfil;
		this.foto_desc = foto_desc;
		this.amigos = amigos;
		this.post = post;
		this.comentarios = comentarios;
	}



	//===================GETTERS===================
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the foto_perfil
	 */
	public String getFoto_perfil() {
		return foto_perfil;
	}

	/**
	 * @return the foto_desc
	 */
	public String getFoto_desc() {
		return foto_desc;
	}

	/**
	 * @return the amigos
	 */
	public Set<Usuario> getAmigos() {
		return amigos;
	}

	/**
	 * @return the post
	 */
	public Set<Publicacion> getPost() {
		return post;
	}

	/**
	 * @return the comentarios
	 */
	public Set<Comentario> getComentarios() {
		return comentarios;
	}
	
	/**
	 * @return the likes_dados
	 */
	public Set<Publicacion> getLikes_dados() {
		return likes_dados;
	}

	
	
	//===================SETTERS===================


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param foto_perfil the foto_perfil to set
	 */
	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}

	/**
	 * @param foto_desc the foto_desc to set
	 */
	public void setFoto_desc(String foto_desc) {
		this.foto_desc = foto_desc;
	}

	/**
	 * @param amigos the amigos to set
	 */
	public void setAmigos(Set<Usuario> amigos) {
		this.amigos = amigos;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Set<Publicacion> post) {
		this.post = post;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * @param likes_dados the likes_dados to set
	 */
	public void setLikes_dados(Set<Publicacion> likes_dados) {
		this.likes_dados = likes_dados;
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
		Usuario other = (Usuario) obj;
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
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", descripcion=" + descripcion + ", foto_perfil="
				+ foto_perfil + ", foto_desc=" + foto_desc + ", amigos=" + amigos + ", post=" + post + ", comentarios="
				+ comentarios +", likes="+ likes_dados + "]";
	}
	
	

}
