package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulcode.soulnews.models.NoticiaFavorita;
import com.soulcode.soulnews.models.NoticiaFavoritaId;

public interface NoticiaFavoritaRepository extends JpaRepository<NoticiaFavorita, NoticiaFavoritaId> {
	
}
