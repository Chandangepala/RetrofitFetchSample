package com.basic.retrofitsample.retrofit.model;

import com.google.gson.JsonArray;

public class NewsResponse {
    public String  status;
    public String totalResults;
    public JsonArray articles;

    public NewsResponse(String status, String totalResults, JsonArray articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonArray getArticles() {
        return articles;
    }

    public void setArticles(JsonArray articles) {
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
