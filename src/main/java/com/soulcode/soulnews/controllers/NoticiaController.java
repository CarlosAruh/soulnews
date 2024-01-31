package com.soulcode.soulnews.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.repositories.NoticiaRepository;

@Controller
public class NoticiaController {

	@Autowired
	private NoticiaRepository noticiaRepository;

	// CREATE
	@PostMapping("/noticias/create")
	public String createNoticia(Noticia noticia) {
		try {
			noticiaRepository.save(noticia);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/noticias";
	}

	// Read
	@GetMapping("/noticias")
	public ModelAndView paginaNoticia() {
		List<Noticia> noticias = noticiaRepository.findAll();

		ModelAndView mv = new ModelAndView("noticias");

		mv.addObject("listaNoticias", noticias);
		return mv;
	}

	// Update
	@PostMapping("/noticias/update")
	public String updateNoticia(Noticia noticia) {
		try {
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(noticia.getIdNoticia());
			if (noticiaOpt.isPresent()) {
				noticiaRepository.save(noticia);
			}
		} catch (Exception ex) {
			return "erro";
		}

		return "redirect:/noticias";
	}

	// Delete
	@PostMapping("/noticias/delete")
	public String deleteNoticia(@RequestParam Integer id) {

		try {
			noticiaRepository.deleteById(id);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/noticias";
	}

	@GetMapping("/noticias/{id}")
	public ModelAndView paginaDetalheNoticia(@PathVariable Integer id) {
		Optional<Noticia> noticiaOpt = noticiaRepository.findById(id);

		if (noticiaOpt.isPresent()) {
			Noticia noticia = noticiaOpt.get();
			ModelAndView mv = new ModelAndView("noticia-detalhe");
			mv.addObject("noticia", noticia);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "O noticia não foi encontrado.");
			return mvErro;
		}
	}

	@GetMapping("/noticias/{id}/edit")
	public ModelAndView paginaAtualizarNoticia(@PathVariable Integer id) {
		Optional<Noticia> noticiaOpt = noticiaRepository.findById(id);

		if (noticiaOpt.isPresent()) {
			Noticia noticia = noticiaOpt.get();
			ModelAndView mv = new ModelAndView("noticia-atualizar");
			mv.addObject("noticia", noticia);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "Noticia não encontrado. Impossível de editar.");
			return mvErro;
		}
	}

}