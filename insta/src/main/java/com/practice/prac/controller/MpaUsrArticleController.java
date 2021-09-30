package com.practice.prac.controller;

import com.practice.prac.domain.Article;
import com.practice.prac.util.Util;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MpaUsrArticleController {
    private int articleLastId = 0;

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
        int id = articleLastId + 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        articleLastId = id;

        Article article = new Article(id, regDate, updateDate, title, body);

        return new ResultData("S-1", id + "번 글이 등록되었습니다.", article);
    }
}

class ResultData {
    private String resultData;
    private String msg;
    private Article article;

    public ResultData(String resultData, String msg, Article article) {
        this.resultData = resultData;
        this.msg = msg;
        this.article = article;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}