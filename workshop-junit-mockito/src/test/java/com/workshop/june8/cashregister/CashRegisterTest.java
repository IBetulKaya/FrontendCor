package com.workshop.june8.cashregister;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CashRegisterTest {

    private Article article;
    private Order order;

    @BeforeEach
    public void execute(){
        article = new Article();
        article.setEan("12345");
        article.setId(1);
        article.setPrice(200.0);
        article.setName("Bicycle");
        article.setDescription("Bicycle for off road");

        order = new Order(1);
        order.addArticle( article, 1);
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    public void testArticleSetWithOneArticleOk(){

        CashRegister.checkout( order, 300.0);
        assertTrue( order.isPaid());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void testArticleSetWithOneArticleNotEnoughCash(){

        CashRegister.checkout( order, 100.0);
        assertFalse( order.isPaid());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void testArticleSetWithOneArticleJustEnoughCash(){
        CashRegister.checkout( order, 200.0);
        assertTrue( order.isPaid());
    }
}
