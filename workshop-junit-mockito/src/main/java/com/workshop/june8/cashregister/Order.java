package com.workshop.june8.cashregister;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private long id;

     private LocalDateTime date ;

    private boolean paid ;

    private List<Article> articles = new ArrayList<>();

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public Order(long id) {
        this.id = id;
        date= LocalDateTime.now();

    }

    public boolean addArticle(Article article, int numberOfArticles){

        for (int i = 0; i < numberOfArticles; i++) {
            articles.add(article);
        }

        return true;
    }
}
