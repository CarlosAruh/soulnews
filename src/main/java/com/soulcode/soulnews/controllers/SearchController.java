package com.soulcode.soulnews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.repositories.NoticiaRepository;

@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private NoticiaRepository noticiaRepository;

	@GetMapping("/noticias")
	public List<Noticia> searchNoticias(@RequestParam String term) {
		List<Noticia> noticias = noticiaRepository.search(term);
		return noticias;
	}

}
