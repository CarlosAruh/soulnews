package com.soulcode.soulnews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.TemaFavorito;
import com.soulcode.soulnews.repositories.TemaFavoritoRepository;

@Controller
public class TemaFavoritoController {

	@Autowired
	private TemaFavoritoRepository temaFavoritoRepository;

	public ModelAndView paginaTemasFavoritos(@RequestParam(name = "idUsuario") Integer idUsuario) {

		if (idUsuario != null) {
			List<TemaFavorito> temasFavoritos = temaFavoritoRepository.findByFkUsuarioId(idUsuario);

			ModelAndView mv = new ModelAndView("temas_favoritos");
			mv.addObject("temasFavoritos", temasFavoritos);
			return mv;
		} else {
			return new ModelAndView("redirect:/alguma-pagina-de-erro");
		}
	}
}