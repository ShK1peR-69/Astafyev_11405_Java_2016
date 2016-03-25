package ru.kpfu.itis.IGOR_ASTAFYEV.model;

public class Comments {
    String author;
    String comment;
    String page;

    public Comments(String author, String comment, String page) {
        this.author = author;
        this.comment = comment;
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
