package ru.kpfu.itis.IGOR_ASTAFYEV.model;


public class News {
    String sport;
    String title;
    String article;

    public News(String sport, String title, String article) {
        this.sport = sport;
        this.title = title;
        this.article = article;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
