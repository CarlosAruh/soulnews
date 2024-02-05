package com.soulcode.soulnews.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "salvos")
public class Salvo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salvo")
	private Integer idSalvo;

	@ManyToOne
	@JoinColumn(name = "fk_usuario_salvo")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "fk_noticia_salvo")
	private Noticia noticiasSalvo;

}