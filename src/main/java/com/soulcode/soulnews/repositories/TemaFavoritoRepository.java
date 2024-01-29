package com.soulcode.soulnews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulcode.soulnews.models.TemaFavorito;

public interface TemaFavoritoRepository extends JpaRepository<TemaFavorito, Integer> {

	List<TemaFavorito> findByFkUsuarioId(Integer idUsuario);
}
