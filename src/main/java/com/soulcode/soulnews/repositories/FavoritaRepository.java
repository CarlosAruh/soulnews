package com.soulcode.soulnews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Favorita;
import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.models.Usuario;

@Repository
public interface FavoritaRepository extends JpaRepository<Favorita, Integer> {
	
	 List<Favorita> findByUsuario(Usuario usuario);
	 
	 boolean existsByUsuarioAndNoticiasFav(Usuario usuario, Noticia noticia);
}
