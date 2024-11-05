package com.workshop.june8.cashregister;

public class CashRegister {
    public static void checkout(Order order, double cash){
        double total = 0;

        for (Article article:order.getArticles()){
            System.out.println(article);
            total+=article.getPrice();
        }

        System.out.println("Total Price :" + total);

        if (total<=cash){
            order.setPaid(true);
        }

        System.out.println( "WisselGeld "+ (cash- total));
        System.out.println("Paid :" + (order.isPaid()?"Yes":"No"));
    }
}
