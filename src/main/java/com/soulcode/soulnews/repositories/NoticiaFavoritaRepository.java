package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.NoticiaFavorita;
import com.soulcode.soulnews.models.NoticiaFavoritaId;

@Repository
public interface NoticiaFavoritaRepository extends JpaRepository<NoticiaFavorita, NoticiaFavoritaId> {

}
