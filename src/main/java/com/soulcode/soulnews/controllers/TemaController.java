package com.soulcode.soulnews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Tema;
import com.soulcode.soulnews.repositories.TemaRepository;

@Controller
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

	@GetMapping("/temas")
	public ModelAndView paginaTemas() {
		List<Tema> temas = temaRepository.findAll();

		ModelAndView mv = new ModelAndView("temas");
		mv.addObject("listaTemas", temas);
		return mv;
	}
}
