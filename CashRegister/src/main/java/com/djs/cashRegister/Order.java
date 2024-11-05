package com.djs.cashRegister;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;

    private LocalDateTime date;

    private boolean paid ;

    private List<Article> articles;

    public Order(long id) {
        this.id = id;
        this.date = LocalDateTime.now();
        this.paid =false;
        this.articles= new ArrayList<>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public boolean addArticle(Article article, int count) {
        if (article == null || count <= 0) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            articles.add(article);
        }
        return true;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", paid=" + paid +
                ", articles=" + articles +
                '}';
    }
}
