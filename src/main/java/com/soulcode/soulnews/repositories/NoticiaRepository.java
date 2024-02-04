package com.soulcode.soulnews.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

	 @Query("SELECT n FROM Noticia n WHERE " +
	           "n.topico LIKE %:term% OR " +
	           "n.titulo LIKE %:term% OR " +
	           "n.caminhoImagem LIKE %:term% OR " +
	           "n.conteudo LIKE %:term% OR " +
	           "n.categoria LIKE %:term% OR " +
	           "n.fonte LIKE %:term%")
	    List<Noticia> search(@Param("term") String term);
	 
	 List<Noticia> findByDataPublicacaoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
