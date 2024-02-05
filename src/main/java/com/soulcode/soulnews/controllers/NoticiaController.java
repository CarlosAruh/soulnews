package com.soulcode.soulnews.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.repositories.NoticiaRepository;

@Controller
public class NoticiaController {

	@Autowired
	private NoticiaRepository noticiaRepository;

	// CREATE
	@PostMapping("/noticias/create")
	public String adicionarNoticia(@RequestParam("topico") String topico, @RequestParam("titulo") String titulo,
			@RequestParam("imagem") MultipartFile imagem, @RequestParam("conteudo") String conteudo,
			@RequestParam("dataPublicacao") LocalDate dataPublicacao, @RequestParam("categoria") String categoria,
			@RequestParam("fonte") String fonte) {

		try {
			String diretorioImagens = "src/main/resources/static/img/";

			String nomeArquivo = UUID.randomUUID().toString() + "_" + imagem.getOriginalFilename();

			String caminhoCompleto = diretorioImagens + nomeArquivo;

			Files.write(Paths.get(caminhoCompleto), imagem.getBytes());

			Noticia noticia = new Noticia();
			noticia.setTopico(topico);
			noticia.setTitulo(titulo);
			noticia.setCaminhoImagem("img/" + nomeArquivo);
			noticia.setConteudo(conteudo);
			noticia.setDataPublicacao(dataPublicacao);
			noticia.setCategoria(categoria);
			noticia.setFonte(fonte);

			noticiaRepository.save(noticia);

			return "redirect:/noticias";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/erro";
		}
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
	public String updateNoticia(@ModelAttribute Noticia noticia, @RequestParam("novaImagem") MultipartFile novaImagem) {
		try {
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(noticia.getIdNoticia());
			if (noticiaOpt.isPresent()) {
				Noticia noticiaExistente = noticiaOpt.get();

				noticiaExistente.setTopico(noticia.getTopico());
				noticiaExistente.setTitulo(noticia.getTitulo());
				noticiaExistente.setConteudo(noticia.getConteudo());
				noticiaExistente.setDataPublicacao(noticia.getDataPublicacao());
				noticiaExistente.setCategoria(noticia.getCategoria());
				noticiaExistente.setFonte(noticia.getFonte());

				if (!novaImagem.isEmpty()) {
					String caminhoNovaImagem = salvarImagem(novaImagem);
					noticiaExistente.setCaminhoImagem(caminhoNovaImagem);
				}

				noticiaRepository.save(noticiaExistente);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
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

	private String salvarImagem(MultipartFile imagem) throws IOException {
		String diretorioImagens = "src/main/resources/static/img/";

		String nomeArquivo = UUID.randomUUID().toString() + "_" + imagem.getOriginalFilename();

		String caminhoCompleto = diretorioImagens + nomeArquivo;

		Files.write(Paths.get(caminhoCompleto), imagem.getBytes());

		return "img/" + nomeArquivo;
	}

}