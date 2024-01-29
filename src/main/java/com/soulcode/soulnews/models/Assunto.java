package com.soulcode.soulnews.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assuntos")
public class Assunto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAssunto;

	@Column(nullable = false, length = 100)
	private String nomeAssunto;

	public Assunto() {

	}

	public Assunto(Integer idAssunto, String nomeAssunto) {
		this.idAssunto = idAssunto;
		this.nomeAssunto = nomeAssunto;
	}

	public Integer getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(Integer idAssunto) {
		this.idAssunto = idAssunto;
	}

	public String getNomeAssunto() {
		return nomeAssunto;
	}

	public void setNomeAssunto(String nomeAssunto) {
		this.nomeAssunto = nomeAssunto;
	}

}
