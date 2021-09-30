package com.practice.prac.controller;

import com.practice.prac.domain.Article;
import com.practice.prac.dto.ResultData;
import com.practice.prac.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MpaUsrArticleController {
    private List<Article> articles;
    private int articleLastId;

    public MpaUsrArticleController() {
        articles = new ArrayList<>();
        articleLastId = 0;
    }

    //    @RequestMapping("/mpaUsr/article/doWrite")
//    @ResponseBody
//    public String doWrite(String title, String body) {
//        int id = articleLastId + 1;
//        String regDate = Util.getNowDateStr();
//        String updateDate = Util.getNowDateStr();
//
//        articleLastId = id;
//
//        Article article = new Article(id, regDate, updateDate, title, body);
//
//        return id + "번 글이 등록되었습니다.";
//    }

    @RequestMapping("/mpaUsr/article/doWrite")
    @ResponseBody
    public ResultData doWrite(String title, String body) {
        int id = writeArticle(title, body);
        Article article = getArticleById(id);

        return new ResultData("S-1", id + "번 글이 등록되었습니다.", article);
    }


    @RequestMapping("/mpaUsr/article/getArticle")
    @ResponseBody
    public ResultData getArticle(int id) {
        Article article = getArticleById(id);
        if (article == null) {
            return new ResultData("F-1", id + "번 글은 존재하지 않습니다.", article);
        }

        return new ResultData("S-1", article.getId() + "번 글 입니다.", article);
    }

    @RequestMapping("/mpaUsr/article/doDelete")
    @ResponseBody
    public ResultData doDelete(int id) {
        boolean deleted = deleteArticleById(id);

        if (deleted == false) {
            return new ResultData("F-1", id + "번 글이 없습니다.");
        }

        return new ResultData("S-1", id + "번 글이 삭제되었습니다.");
    }

    private int writeArticle(String title, String body) {
        int id = articleLastId + 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        Article article = new Article(id, regDate, updateDate, title, body);

        articleLastId = id;
        articles.add(article);

        return id;
    }

    private Article getArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    private boolean deleteArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                articles.remove(article);
                return true;
            }
        }
        return false;
    }
}