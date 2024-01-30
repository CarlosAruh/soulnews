package com.soulcode.soulnews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

	/*@Query("SELECT n FROM Noticia n JOIN n.usuariosFavoritos u WHERE u.id = :userId")
	List<Noticia> findFavoritasByUsuario(@Param("userId") Integer userId);*/

}
