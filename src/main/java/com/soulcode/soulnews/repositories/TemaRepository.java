package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

}
