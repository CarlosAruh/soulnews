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

import com.soulcode.soulnews.models.Usuario;
import com.soulcode.soulnews.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// CREATE
	@GetMapping("/cadastro")
	public ModelAndView getMethodName() {
		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}
	
	@PostMapping("/usuarios/create")
	public String createUsuario(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/usuarios";
	}

	// Read
	@GetMapping("/usuarios")
	public ModelAndView paginaUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		ModelAndView mv = new ModelAndView("usuarios");

		mv.addObject("listaUsuarios", usuarios);
		return mv;
	}

	// Update
	@PostMapping("/usuarios/update")
	public String updateUsuario(Usuario usuario) {
		try {
			Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuario.getIdUsuario());
			if (usuarioOpt.isPresent()) {
				usuarioRepository.save(usuario);
			}
		} catch (Exception ex) {
			return "erro";
		}

		return "redirect:/usuarios";
	}

	// Delete
	@PostMapping("/usuarios/delete")
	public String deleteUsuario(@RequestParam Integer id) {

		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			return "erro";
		}

		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/{id}")
	public ModelAndView paginaDetalheUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			ModelAndView mv = new ModelAndView("usuario-detalhe");
			mv.addObject("usuario", usuario);
			return mv;
		} else {
			ModelAndView mvErro = new ModelAndView("erro");
			mvErro.addObject("msg", "O usuario não foi encontrado.");
			return mvErro;
		}
	}
	
	@GetMapping("/usuarios/{id}/edit")
    public ModelAndView paginaAtualizarUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if(usuarioOpt.isPresent()) { 
            Usuario usuario = usuarioOpt.get();
            ModelAndView mv = new ModelAndView("usuario-atualizar");
            mv.addObject("usuario", usuario);
            return mv;
        } else {
            ModelAndView mvErro = new ModelAndView("erro");
            mvErro.addObject("msg", "Usuario não encontrado. Impossível de editar.");
            return mvErro;
        }
    }

}
