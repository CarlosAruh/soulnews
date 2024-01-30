package com.soulcode.soulnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.soulnews.models.NoticiaDepois;
import com.soulcode.soulnews.models.NoticiaDepoisId;

@Repository
public interface NoticiaDepoisRepository extends JpaRepository<NoticiaDepois, NoticiaDepoisId> {

}
