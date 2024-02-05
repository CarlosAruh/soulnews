package com.soulcode.soulnews.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.repositories.NoticiaRepository;

@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private NoticiaRepository noticiaRepository;

	@GetMapping("/noticias-busca")
	public ModelAndView searchNoticias(@RequestParam String term, Model model) {
		List<Noticia> noticias = noticiaRepository.search(term);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa");
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}

	@GetMapping("/noticias-entre-datas")
	public List<Noticia> searchNoticiasByDateRange(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		return noticiaRepository.findByDataPublicacaoBetween(dataInicial, dataFinal);
	}

	@GetMapping("/noticias-data")
	public ModelAndView searchByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
			Model model) {
		List<Noticia> noticias = noticiaRepository.searchByDate(dataInicial);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa"); // Substitua "noticia-data" pelo nome real da
																			// sua página HTML.
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}

	// aqui
	@GetMapping("/noticias-topico")
	public ModelAndView searchTopicos(@RequestParam String topic, Model model) {
		List<Noticia> noticias = noticiaRepository.search(topic);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa");
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}

	@GetMapping("/noticias-titulo")
	public ModelAndView searchTitulos(@RequestParam String title, Model model) {
		List<Noticia> noticias = noticiaRepository.search(title);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa");
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}

	@GetMapping("/noticias-conteudos")
	public ModelAndView searchConteudos(@RequestParam String content, Model model) {
		List<Noticia> noticias = noticiaRepository.search(content);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa");
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}

	@GetMapping("/noticias-categoria")
	public ModelAndView searchCategorias(@RequestParam String category, Model model) {
		List<Noticia> noticias = noticiaRepository.search(category);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa");
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}

	@GetMapping("/noticias-fonte")
	public ModelAndView searchFontes(@RequestParam String source, Model model) {
		List<Noticia> noticias = noticiaRepository.search(source);

		ModelAndView modelAndView = new ModelAndView("noticia-pesquisa");
		modelAndView.addObject("noticias", noticias);

		return modelAndView;
	}
}