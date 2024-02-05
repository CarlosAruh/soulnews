package com.soulcode.soulnews.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Favorita;
import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.models.Usuario;
import com.soulcode.soulnews.repositories.FavoritaRepository;
import com.soulcode.soulnews.repositories.NoticiaRepository;
import com.soulcode.soulnews.repositories.UsuarioRepository;

@Controller
public class FavoritaController {

	@Autowired
	private FavoritaRepository favoritaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private NoticiaRepository noticiaRepository;

	// CREATE
	@PostMapping("/favoritas/create")
	public String createNoticiaFavorita(@RequestParam Integer idUsuario, @RequestParam Integer idNoticia,
			Favorita favorita) {
		try {
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(idNoticia);
			if (usuarioOpt.isPresent() && noticiaOpt.isPresent()) {
				Usuario usuario = usuarioOpt.get();
				Noticia noticia = noticiaOpt.get();

				favorita.setUsuario(usuario);
				favorita.setNoticiasFav(noticia);

				favoritaRepository.save(favorita);
			}

		} catch (Exception ex) {
			return "erro";
		}
		return "redirect:/favoritas";
	}

	// READ
	@GetMapping("/favoritas")
	public ModelAndView paginasFavoritas() {
		List<Favorita> favoritas = favoritaRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Noticia> noticias = noticiaRepository.findAll();

		ModelAndView mv = new ModelAndView("favoritas");
		mv.addObject("listaFavoritas", favoritas);
		mv.addObject("listaUsuarios", usuarios);
		mv.addObject("listaNoticias", noticias);

		return mv;
	}

	@GetMapping("/favoritas/{id}")
	public ModelAndView paginaDetalheFavoritas(@PathVariable Integer id) {
		Optional<Favorita> favoritaOpt = favoritaRepository.findById(id);

		if (favoritaOpt.isPresent()) {
			Favorita favorita = favoritaOpt.get();
			ModelAndView mv = new ModelAndView("favorita-detalhe");
			mv.addObject("favorita", favorita);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "O favorita não foi encontrado");
			return mvErro;
		}

	}

	// Update
	@PostMapping("/favoritas/update")
	public String updateNoticiasFavoritas(@RequestParam Integer idUsuario, @RequestParam Integer idNoticia,
			Favorita favorita) {

		try {
			Optional<Favorita> existingFavoritaOpt = favoritaRepository.findById(favorita.getIdFavorita());
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(idNoticia);

			if (existingFavoritaOpt.isPresent() && usuarioOpt.isPresent() && noticiaOpt.isPresent()) {
				Favorita existingFavorita = existingFavoritaOpt.get();
				Usuario usuario = usuarioOpt.get();
				Noticia noticia = noticiaOpt.get();

				existingFavorita.setUsuario(usuario);
				existingFavorita.setNoticiasFav(noticia);

				favoritaRepository.save(existingFavorita);
			}
		} catch (Exception ex) {
			return "erro";
		}

		return "redirect:/favoritas";
	}

	@GetMapping("/favoritas/{id}/edit")
	public ModelAndView paginaAtualizarFavorita(@PathVariable Integer id) {
		Optional<Favorita> favoritaOpt = favoritaRepository.findById(id);
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Noticia> noticias = noticiaRepository.findAll();

		if (favoritaOpt.isPresent()) {
			Favorita favorita = favoritaOpt.get();
			ModelAndView mv = new ModelAndView("favorita-atualizar");
			mv.addObject("favorita", favorita);
			mv.addObject("listaUsuarios", usuarios);
			mv.addObject("listaNoticias", noticias);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "Favorita não encontrado. Impossível de editar.");
			return mvErro;
		}
	}

	// Delete
	@PostMapping("/favoritas/delete")
	public String deleteNoticiaFavorita(@RequestParam Integer id) {

		try {
			favoritaRepository.deleteById(id);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/favoritas";
	}

}
