package com.springboot.dao;

import com.springboot.entity.TArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends JpaRepository<TArticle,Integer> {

   // Page<TArticle> findByKeyword(String kw, Pageable pageable);

}
