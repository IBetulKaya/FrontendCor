package com.djs.cashRegister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Order order = new Order(1);
        Article article1 = new Article(1, "123", "Apple", 2.0, "Apple");
        Article article2 = new Article(2, "456", "Water", 0.5, "Water");
        Article article3 = new Article(3, "789", "Bread", 1.5, "Bread");
        Article article4 = new Article(4, "777", "Milk", 1.5, "Milk");
        Article article5 = new Article(5, "333", "Cola", 3.5, "Cola");

        Scanner scanner = new Scanner(System.in);

        List<Article> allArticles = new ArrayList<Article>();
        allArticles.add(article1);
        allArticles.add(article2);
        allArticles.add(article3);
        allArticles.add(article4);
        allArticles.add(article5);

        for (Article article : allArticles) {
            System.out.println(article);
        }

        while (true) {
            Article product = new Article();
            System.out.println("Please select article with id : ");
            long id = scanner.nextLong();
            if (id > 0 && id < 6) {
                for (Article article : allArticles) {

                    if (article.getId() == id) {
                        product = article;
                    }
                }

                System.out.println("Please select number of article : ");
                int count = scanner.nextInt();
                order.addArticle(product, count);


            } else {
                System.out.println("id must be between 0 and 5");
            }
            System.out.println();
            System.out.println("1- Continue select article : \n" +
                    "2- exit");
            String choice = scanner.next();
            System.out.println();
            if (choice.equals("2")) {
                break;
            }

        }

        System.out.println("Please enter cash :");
        double cash = scanner.nextDouble();

        CashRegister.checkout(order, cash);
        System.out.println(" Paid Status: " + order.isPaid());

    }
}




