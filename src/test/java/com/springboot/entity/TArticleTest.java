package com.springboot.entity;


import com.springboot.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class TArticleTest {
    @Resource
    ArticleService articleService;

    @Test
    public void testArticle(){
        TArticle article = new TArticle();
        article.setId(0);
        article.setPoem_name("libai");
        article.setGender(TArticle.Sex.男);
        article.setPoetry_name("望庐山");
        articleService.save(article);


    }
}
