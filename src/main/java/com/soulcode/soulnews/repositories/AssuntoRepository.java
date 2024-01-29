package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Assunto;

@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Integer>{

}
