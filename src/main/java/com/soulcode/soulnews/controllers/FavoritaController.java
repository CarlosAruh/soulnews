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
	public String favoritarNoticia(@RequestParam Integer idNoticia, Favorita favorita) {
		try {
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(idNoticia);
			if (noticiaOpt.isPresent()) {
				Noticia noticia = noticiaOpt.get();
				if (noticia.getFavorita()) {
				noticia.setFavorita(false);
				System.out.println(noticia.getFavorita());
				} else {
				noticia.setFavorita(true);
				System.out.println(noticia.getFavorita());
				}
				favoritaRepository.save(favorita);
			}

		} catch (Exception ex) {
			return "erro";
		}
		return "redirect:/favoritas";
	}

	// READ
	@GetMapping("/favoritas")
	public ModelAndView paginaFavoritas() {
		List<Noticia> noticias = noticiaRepository.searchByFavorita();

		ModelAndView mv = new ModelAndView("favoritas");
		mv.addObject("listaFavoritas", noticias);

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
			@RequestParam(name = "dataAdicao") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataAdicao,
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
				existingFavorita.setDataAdicao(dataAdicao);

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
