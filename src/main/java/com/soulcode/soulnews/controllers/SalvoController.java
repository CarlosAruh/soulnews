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

import com.soulcode.soulnews.models.Salvo;
import com.soulcode.soulnews.models.Noticia;
import com.soulcode.soulnews.models.Usuario;
import com.soulcode.soulnews.repositories.SalvoRepository;
import com.soulcode.soulnews.repositories.NoticiaRepository;
import com.soulcode.soulnews.repositories.UsuarioRepository;

@Controller
public class SalvoController {

	@Autowired
	private SalvoRepository salvoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private NoticiaRepository noticiaRepository;

	// CREATE
	@PostMapping("/salvos/create")
	public String createNoticiaSalvo(@RequestParam Integer idUsuario, @RequestParam Integer idNoticia, Salvo salvo) {
		try {
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(idNoticia);
			if (usuarioOpt.isPresent() && noticiaOpt.isPresent()) {
				Usuario usuario = usuarioOpt.get();
				Noticia noticia = noticiaOpt.get();

				salvo.setUsuario(usuario);
				salvo.setNoticiasSalvo(noticia);

				salvoRepository.save(salvo);
			}

		} catch (Exception ex) {
			return "erro";
		}
		return "redirect:/salvos";
	}

	// READ
	@GetMapping("/salvos")
	public ModelAndView paginasSalvos() {
		List<Salvo> salvos = salvoRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Noticia> noticias = noticiaRepository.findAll();

		ModelAndView mv = new ModelAndView("salvos");
		mv.addObject("listaSalvos", salvos);
		mv.addObject("listaUsuarios", usuarios);
		mv.addObject("listaNoticias", noticias);

		return mv;
	}

	@GetMapping("/salvos/{id}")
	public ModelAndView paginaDetalheSalvos(@PathVariable Integer id) {
		Optional<Salvo> salvoOpt = salvoRepository.findById(id);

		if (salvoOpt.isPresent()) {
			Salvo salvo = salvoOpt.get();
			ModelAndView mv = new ModelAndView("salvo-detalhe");
			mv.addObject("salvo", salvo);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "O salvo não foi encontrado");
			return mvErro;
		}

	}

	// Update
	@PostMapping("/salvos/update")
	public String updateNoticiasSalvos(@RequestParam Integer idUsuario, @RequestParam Integer idNoticia, Salvo salvo) {

		try {
			Optional<Salvo> existingSalvoOpt = salvoRepository.findById(salvo.getIdSalvo());
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
			Optional<Noticia> noticiaOpt = noticiaRepository.findById(idNoticia);

			if (existingSalvoOpt.isPresent() && usuarioOpt.isPresent() && noticiaOpt.isPresent()) {
				Salvo existingSalvo = existingSalvoOpt.get();
				Usuario usuario = usuarioOpt.get();
				Noticia noticia = noticiaOpt.get();

				existingSalvo.setUsuario(usuario);
				existingSalvo.setNoticiasSalvo(noticia);

				salvoRepository.save(existingSalvo);
			}
		} catch (Exception ex) {
			return "erro";
		}

		return "redirect:/salvos";
	}

	@GetMapping("/salvos/{id}/edit")
	public ModelAndView paginaAtualizarSalvo(@PathVariable Integer id) {
		Optional<Salvo> salvoOpt = salvoRepository.findById(id);
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Noticia> noticias = noticiaRepository.findAll();

		if (salvoOpt.isPresent()) {
			Salvo salvo = salvoOpt.get();
			ModelAndView mv = new ModelAndView("salvo-atualizar");
			mv.addObject("salvo", salvo);
			mv.addObject("listaUsuarios", usuarios);
			mv.addObject("listaNoticias", noticias);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "Salvo não encontrado. Impossível de editar.");
			return mvErro;
		}
	}

	// Delete
	@PostMapping("/salvos/delete")
	public String deleteNoticiaSalvo(@RequestParam Integer id) {

		try {
			salvoRepository.deleteById(id);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/salvos";
	}

}
