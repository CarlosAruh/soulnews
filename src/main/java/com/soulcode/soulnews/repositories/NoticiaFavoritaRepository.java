package com.soulcode.soulnews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.NoticiaFavorita;
import com.soulcode.soulnews.models.NoticiaFavoritaId;
import com.soulcode.soulnews.models.Usuario;

@Repository
public interface NoticiaFavoritaRepository extends JpaRepository<NoticiaFavorita, NoticiaFavoritaId> {
	
	 List<NoticiaFavorita> findByUsuario(Usuario usuario);
}
