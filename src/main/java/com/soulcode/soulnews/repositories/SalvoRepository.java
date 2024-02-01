package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Salvo;

@Repository
public interface SalvoRepository extends JpaRepository<Salvo, Integer> {

}
