
package com.example.user.anthariksh;

import java.util.List;

@SuppressWarnings("unused")
public class TimesOfIndia {

    private List<Article> articles;
    private String status;
    private Long totalResults;

    public TimesOfIndia(List<Article> articles, String status, Long totalResults) {
        this.articles = articles;
        this.status = status;
        this.totalResults = totalResults;
    }


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }
}
