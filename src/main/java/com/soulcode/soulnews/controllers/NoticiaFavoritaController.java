package com.soulcode.soulnews.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.models.NoticiaFavorita;
import com.soulcode.soulnews.models.Usuario;
import com.soulcode.soulnews.repositories.NoticiaFavoritaRepository;
import com.soulcode.soulnews.repositories.NoticiaRepository;
import com.soulcode.soulnews.repositories.UsuarioRepository;

@Controller
public class NoticiaFavoritaController {

	@Autowired
	private NoticiaFavoritaRepository noticiaFavoritaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private NoticiaRepository noticiaRepository;

	@GetMapping("/noticias-favoritas")
	public ModelAndView paginaFavoritas() {
		List<NoticiaFavorita> favoritas = noticiaFavoritaRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Noticia> noticias = noticiaRepository.findAll();

		ModelAndView mv = new ModelAndView("noticias-favoritas");
		mv.addObject("listaFavoritas", favoritas);
		mv.addObject("listaUsuarios", usuarios);
		mv.addObject("listaNoticias", noticias);

		return mv;
	}

	
}
