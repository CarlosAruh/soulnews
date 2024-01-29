package com.soulcode.soulnews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.soulnews.models.Usuario;
import com.soulcode.soulnews.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public ModelAndView paginaUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		ModelAndView mv = new ModelAndView("usuarios");

		mv.addObject("listaUsuarios", usuarios);
		return mv;
	}
}
