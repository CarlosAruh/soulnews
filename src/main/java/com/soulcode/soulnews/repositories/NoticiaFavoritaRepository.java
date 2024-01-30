package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulcode.soulnews.models.TemaFavorito;
import com.soulcode.soulnews.models.TemaFavoritoId;

public interface TemaFavoritoRepository extends JpaRepository<TemaFavorito, TemaFavoritoId> {
	
}
