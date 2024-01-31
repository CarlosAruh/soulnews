package com.soulcode.soulnews.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "noticias_favoritas")
public class NoticiaFavorita {

	@EmbeddedId
	private NoticiaFavoritaId noticiaFavoritaId;

	@ManyToOne
	@MapsId("fkUsuario")
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;

	@ManyToOne
	@MapsId("fkNoticia")
	@JoinColumn(name = "fk_noticia")
	private Noticia noticiasFav;

}
