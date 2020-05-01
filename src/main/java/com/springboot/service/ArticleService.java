package com.springboot.service;


import com.springboot.entity.TArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    public void save(TArticle tArticle);
    public Page<TArticle> findAll (String kw, Pageable pageable);
    public TArticle findById(Integer id);
    void delete(TArticle tArticle);
    void deleteById(Integer id);
    void deletes(List<TArticle> tArticles);
}
