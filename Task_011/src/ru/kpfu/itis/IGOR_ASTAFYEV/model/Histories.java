package ru.kpfu.itis.IGOR_ASTAFYEV.model;


public class Histories {
    String game_name;
    String article;
    String head;

    public Histories(String game_name, String article, String head) {
        this.game_name = game_name;
        this.article = article;
        this.head = head;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
