package com.practice.prac.dto;

import com.practice.prac.domain.Article;

public class ResultData {
    private String resultData;
    private String msg;
    private Article article;

    public ResultData(String resultData, String msg, Article article) {
        this.resultData = resultData;
        this.msg = msg;
        this.article = article;
    }

    public ResultData(String resultData, String msg) {
        this.resultData = resultData;
        this.msg = msg;
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