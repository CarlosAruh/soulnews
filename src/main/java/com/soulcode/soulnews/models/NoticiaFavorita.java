package com.soulcode.soulnews.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="noticias_favoritas")
public class NoticiaFavorita {
	
	@EmbeddedId
	private NoticiaFavoritaId noticiaFavoritaId;
	
	@ManyToOne
	@MapsId("fkUsuario")
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("fkNoticia")
	@JoinColumn(name="fk_noticia")
	private Noticia noticiasFv;

	public NoticiaFavoritaId getNoticiaFavoritaId() {
		return noticiaFavoritaId;
	}

	public void setNoticiaFavoritaId(NoticiaFavoritaId noticiaFavoritaId) {
		this.noticiaFavoritaId = noticiaFavoritaId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Noticia getNoticiasFv() {
		return noticiasFv;
	}

	public void setNoticiasFv(Noticia noticiasFv) {
		this.noticiasFv = noticiasFv;
	}
	
	
	
}
