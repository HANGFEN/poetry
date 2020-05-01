package com.springboot.imp;

import com.springboot.dao.ArticleDao;
import com.springboot.entity.TArticle;
import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TArticleImp implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void save(TArticle tArticle) {
        articleDao.save(tArticle);
    }

    @Override
    public Page<TArticle> findAll(String kw, Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<TArticle> findAll(String kw, Pageable pageable) {
//        return articleDao.findByKeyword(kw,pageable);
//
//    }

    @Override
    public TArticle findById(Integer id) {
        return null;
    }

    @Override
    public void delete(TArticle tArticle) {
        articleDao.delete(tArticle);
    }

    @Override
    public void deleteById(Integer id) {
        articleDao.deleteById(id);
    }

    @Override
    @Transactional //数据完整型
    public void deletes(List<TArticle> tArticles) {
        for(TArticle tArticle1 : tArticles) {
            articleDao.delete(tArticle1);
        }
    }
}
