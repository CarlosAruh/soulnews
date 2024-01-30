package com.soulcode.soulnews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.models.NoticiaDepois;
import com.soulcode.soulnews.models.Usuario;
import com.soulcode.soulnews.repositories.NoticiaDepoisRepository;
import com.soulcode.soulnews.repositories.NoticiaRepository;
import com.soulcode.soulnews.repositories.UsuarioRepository;

@Controller
public class NoticiaDepoisController {

	@Autowired
	private NoticiaDepoisRepository noticiaDepoisRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private NoticiaRepository noticiaRepository;

	@GetMapping("/noticias-salvas")
	public ModelAndView paginaDepois() {
		List<NoticiaDepois> depois = noticiaDepoisRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Noticia> noticias = noticiaRepository.findAll();

		ModelAndView mv = new ModelAndView("noticias-salvas");
		mv.addObject("listaDepois", depois);
		mv.addObject("listaUsuarios", usuarios);
		mv.addObject("listaNoticias", noticias);

		return mv;
	}

}
