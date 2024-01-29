package com.soulcode.soulnews.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 180, unique = true)
	private String email;

	@Column(nullable = false)
	private Instant dataNascimento;

	@Column(nullable = false, length = 20)
	private String telefone;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;

	public Usuario() {

	}

	public Usuario(Integer idUsuario, String nome, String email, Instant dataNascimento, String telefone, String cpf) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
