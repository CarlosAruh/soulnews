package com.soulcode.soulnews.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@Embeddable
public class NoticiaDepoisId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "fk_usuario")
	private Integer fkUsuario;

	@Column(name = "fk_noticias")
	private Integer fkNoticia;

}
