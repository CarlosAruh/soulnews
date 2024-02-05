package com.soulcode.soulnews.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

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

        ModelAndView modelAndView = new ModelAndView("noticia-pesquisa"); // Substitua "nomeDaSuaPagina" pelo nome real da sua página HTML.
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
    public ModelAndView searchByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, Model model) {
        List<Noticia> noticias = noticiaRepository.searchByDate(dataInicial);
    
        ModelAndView modelAndView = new ModelAndView("noticia-pesquisa"); // Substitua "noticia-data" pelo nome real da sua página HTML.
        modelAndView.addObject("noticias", noticias);
    
        return modelAndView;
    }

}
