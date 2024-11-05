package com.djs.cashRegister;

import java.util.List;

public class CashRegister {

    // Static method for checkout
    public static double checkout(Order order, double cash) {
        List<Article> articles = order.getArticles();
        double totalPrice = 0.0;



        System.out.println("Articles in the order:");
        for (Article article : articles) {
            System.out.println(article);
            totalPrice+= article.getPrice();
        }

        System.out.println("Total price: " + totalPrice);


        System.out.println("Cash provided: " + cash);


        double change = cash - totalPrice;

        System.out.println("Change: " + change);
        if(cash>totalPrice){
            order.setPaid(true);

        }




        return change;
    }




    }





