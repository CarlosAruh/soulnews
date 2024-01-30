package com.soulcode.soulnews.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "temas_favoritos")
public class TemaFavorito {

	@EmbeddedId
	private TemaFavoritoId id;

	@ManyToOne
	@MapsId("fkUsuarioId")
	@JoinColumn(name = "fk_usuario_id")
	private Usuario usuario;

	@ManyToOne
	@MapsId("fkAssuntoId")
	@JoinColumn(name = "fk_assunto_id")
	private Assunto assunto;

	public TemaFavoritoId getId() {
		return id;
	}

	public void setId(TemaFavoritoId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

}
