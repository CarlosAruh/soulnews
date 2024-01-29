package com.soulcode.soulnews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "temas_favoritos")
public class TemaFavorito {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_assunto")
	private Assunto assunto;

	public TemaFavorito() {

	}

	public TemaFavorito(Usuario usuario, Assunto assunto) {
		this.usuario = usuario;
		this.assunto = assunto;
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
