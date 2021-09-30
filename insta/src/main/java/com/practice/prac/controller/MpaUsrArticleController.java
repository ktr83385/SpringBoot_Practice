package com.practice.prac.controller;

import com.practice.prac.domain.Article;
import com.practice.prac.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MpaUsrArticleController {
    private int articleLastId = 0;

    @RequestMapping("/mpaUsr/article/doWrite")
    @ResponseBody
    public Article doWrite(String title, String body) {
        int id = articleLastId + 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        articleLastId = id;

        Article article = new Article(id, regDate, updateDate, title, body);

        return article;
    }
}