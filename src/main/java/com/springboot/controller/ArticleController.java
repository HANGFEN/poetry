package com.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.entity.TArticle;
import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/selectpoetry")
    public String list(String kw, Model model, Pageable pageable){
        Page<TArticle> tArticlePage = articleService.findAll("page", (org.springframework.data.domain.Pageable) pageable);
        return "selectpoetry";
    }

    @GetMapping({"/editusers","/edituser/{aid}"})
    public String edit(@PathVariable(name="uid",required = false)Integer aid,Model model) {
        TArticle tArticle = new TArticle();
        if(aid != null&&aid > 0){
            tArticle =articleService.findById(aid);
        }
        model.addAttribute(tArticle);
        return "editusers";
    }

    @PostMapping("/saveaticle")
    public String save(@Valid TArticle tArticle, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/edit";
        }
        articleService.save(tArticle);
        return "redirect:/listarticle";
    }

    @GetMapping("/delete/{aids}")
    public String delets(@PathVariable("aids") String aids){
        List<TArticle> tArticleLists = new ArrayList<>();
        JSONObject json = JSONObject.parseObject(aids);
        JSONArray arr = json.getJSONArray("aids");
        int ilen = arr.size();
        for (int i = 0;i < ilen;i++){
            tArticleLists.add(articleService.findById(arr.getInteger(i)));
        }
        articleService.deletes( tArticleLists);
        return "redict:/listaricle";
    }


}
