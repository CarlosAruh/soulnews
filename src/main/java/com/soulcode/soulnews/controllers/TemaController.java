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

import com.soulcode.soulnews.models.Tema;
import com.soulcode.soulnews.repositories.TemaRepository;

@Controller
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

	// CREATE
	@PostMapping("/temas/create")
	public String createTema(Tema tema) {
		try {
			temaRepository.save(tema);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/temas";
	}

	// Read
	@GetMapping("/temas")
	public ModelAndView paginaTema() {
		List<Tema> temas = temaRepository.findAll();

		ModelAndView mv = new ModelAndView("temas");

		mv.addObject("listaTemas", temas);
		return mv;
	}

	// Update
	@PostMapping("/temas/update")
	public String updateTema(Tema tema) {
		try {
			Optional<Tema> temaOpt = temaRepository.findById(tema.getIdTemas());
			if (temaOpt.isPresent()) {
				temaRepository.save(tema);
			}
		} catch (Exception ex) {
			return "erro";
		}

		return "redirect:/temas";
	}

	// Delete
	@PostMapping("/temas/delete")
	public String deleteTema(@RequestParam Integer id) {

		try {
			temaRepository.deleteById(id);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/temas";
	}

	@GetMapping("/temas/{id}")
	public ModelAndView paginaDetalheTema(@PathVariable Integer id) {
		Optional<Tema> temaOpt = temaRepository.findById(id);

		if (temaOpt.isPresent()) {
			Tema tema = temaOpt.get();
			ModelAndView mv = new ModelAndView("tema-detalhe");
			mv.addObject("tema", tema);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "O tema não foi encontrado.");
			return mvErro;
		}
	}

	@GetMapping("/temas/{id}/edit")
	public ModelAndView paginaAtualizarTema(@PathVariable Integer id) {
		Optional<Tema> temaOpt = temaRepository.findById(id);

		if (temaOpt.isPresent()) {
			Tema tema = temaOpt.get();
			ModelAndView mv = new ModelAndView("tema-atualizar");
			mv.addObject("tema", tema);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "Tema não encontrado. Impossível de editar.");
			return mvErro;
		}
	}

}
