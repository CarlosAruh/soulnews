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

	 @Query("SELECT n FROM Noticia n WHERE n.dataPublicacao > :dataInicial")
	 List<Noticia> searchByDate(@Param("dataInicial") LocalDate dataInicial);
	 
	 @Query("SELECT n FROM Noticia n WHERE " +
	           "n.topico LIKE %:term%")
	    List<Noticia> searchTopic(@Param("term") String topic);
	 
	 @Query("SELECT n FROM Noticia n WHERE " +
	           "n.titulo LIKE %:term%")
	    List<Noticia> searchTitle(@Param("term") String title);
	 
	 @Query("SELECT n FROM Noticia n WHERE " +
			   "n.conteudo LIKE %:term%")
	    List<Noticia> searchContent(@Param("term") String content);
	 
	 @Query("SELECT n FROM Noticia n WHERE " +
			   "n.categoria LIKE %:term%")
	    List<Noticia> searchCategory(@Param("term") String category);
	 
	 @Query("SELECT n FROM Noticia n WHERE " +
			   "n.fonte LIKE %:term%")
	    List<Noticia> searchSource(@Param("term") String source);
}
