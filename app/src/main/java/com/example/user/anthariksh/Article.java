
package com.example.user.anthariksh;


@SuppressWarnings("unused")
public class Article {




    private String description;


    private String title;

    private String url;
    private String urlToImage;

    public Article(String description, String title, String url, String urlToImage) {
        this.description = description;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
