package com.soulcode.soulnews.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "noticias")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNoticia;

	@Column(nullable = false, length = 255, unique = true)
	private String titulo;

	@Column(length = 4000)
	private String conteudo;

	@Column(nullable = false)
	private Instant dataPublicacao;

	@ManyToOne
	@JoinColumn(name = "id_assunto", nullable = false)
	private Assunto assunto;

	public Noticia() {

	}

	public Noticia(Integer idNoticia, String titulo, String conteudo, Instant dataPublicacao, Assunto assunto) {
		this.idNoticia = idNoticia;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataPublicacao = dataPublicacao;
		this.assunto = assunto;
	}

	public Integer getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Integer idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Instant getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Instant dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

}
