package com.soulcode.soulnews.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//CREATE
	@PostMapping("/noticias-favoritas/create")
	public String createNoticiaFavorita(@RequestParam Integer idUsuario, @RequestParam Integer IdNoticia,
			NoticiaFavorita noticiaFavorita) {
		try {
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(IdNoticia);
			if (usuarioOpt.isPresent() && noticiaOpt.isPresent()) {
				Usuario usuario = usuarioOpt.get();
				Noticia noticia = noticiaOpt.get();

				noticiaFavorita.setUsuario(usuario);
				noticiaFavorita.setNoticiasFav(noticia);

				noticiaFavoritaRepository.save(noticiaFavorita);
			}

		} catch (Exception ex) {
			return "erro";
		}
		return "redirect:/noticias-favoritas";
	}
	
	//READ
	@GetMapping("/noticias-favoritas")
	public ModelAndView paginasFavoritas() {
		List<NoticiaFavorita> favoritas = noticiaFavoritaRepository.findAll();

		ModelAndView mv = new ModelAndView("noticias-favoritas");
		mv.addObject("listaFavoritas", favoritas);

		return mv;
	}
	
	
}
