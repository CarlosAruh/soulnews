package com.soulcode.soulnews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulcode.soulnews.models.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

    List<Noticia> findByFkAssuntoId(Integer idAssunto);
}
