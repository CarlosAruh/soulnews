package com.soulcode.soulnews.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NoticiaFavoritaId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="fk_usuario")
	private Integer fkUsuario;
	
	@Column(name="fk_noticias")
	private Integer fkNoticia;
	
	public NoticiaFavoritaId() {
		
	}

	public NoticiaFavoritaId(Integer fkUsuario, Integer fkNoticia) {
		this.fkUsuario = fkUsuario;
		this.fkNoticia = fkNoticia;
	}

	public Integer getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(Integer fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public Integer getFkNoticia() {
		return fkNoticia;
	}

	public void setFkNoticia(Integer fkNoticia) {
		this.fkNoticia = fkNoticia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkNoticia, fkUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticiaFavoritaId other = (NoticiaFavoritaId) obj;
		return Objects.equals(fkNoticia, other.fkNoticia) && Objects.equals(fkUsuario, other.fkUsuario);
	}
	
	
}
