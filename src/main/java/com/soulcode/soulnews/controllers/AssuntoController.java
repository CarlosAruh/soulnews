package com.soulcode.soulnews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Assunto;
import com.soulcode.soulnews.repositories.AssuntoRepository;

@Controller
public class AssuntoController {

	@Autowired
	private AssuntoRepository assuntoRepository;

	@GetMapping("/assuntos")
	public ModelAndView paginaAssuntos() {
		List<Assunto> assuntos = assuntoRepository.findAll();

		ModelAndView mv = new ModelAndView("assuntos");

		mv.addObject("listaAssuntos", assuntos);
		return mv;
	}
}
