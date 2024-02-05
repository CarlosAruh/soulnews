package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.Favorita;

@Repository
public interface FavoritaRepository extends JpaRepository<Favorita, Integer> {
}
