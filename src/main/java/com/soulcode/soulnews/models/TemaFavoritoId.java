package com.soulcode.soulnews.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TemaFavoritoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "fk_usuario_id")
	private Integer fkUsuarioId;

	@Column(name = "fk_assunto_id")
	private Integer fkAssuntoId;

	public TemaFavoritoId() {

	}

	public TemaFavoritoId(Integer fkUsuarioId, Integer fkAssuntoId) {
		this.fkUsuarioId = fkUsuarioId;
		this.fkAssuntoId = fkAssuntoId;
	}

	public Integer getFkUsuarioId() {
		return fkUsuarioId;
	}

	public void setFkUsuarioId(Integer fkUsuarioId) {
		this.fkUsuarioId = fkUsuarioId;
	}

	public Integer getFkAssuntoId() {
		return fkAssuntoId;
	}

	public void setFkAssuntoId(Integer fkAssuntoId) {
		this.fkAssuntoId = fkAssuntoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkUsuarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemaFavoritoId other = (TemaFavoritoId) obj;
		return Objects.equals(fkUsuarioId, other.fkUsuarioId);
	}

}
