package com.soulcode.soulnews.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
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
	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;

	@Column(nullable = false, length = 20)
	private String telefone;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;

}
