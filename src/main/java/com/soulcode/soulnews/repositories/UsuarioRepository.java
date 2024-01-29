package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulcode.soulnews.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
}
