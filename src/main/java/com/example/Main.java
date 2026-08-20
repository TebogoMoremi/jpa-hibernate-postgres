package com.example;

import com.example.entity.CashInTransaction;
import com.example.entity.CashOutTransaction;
import com.example.entity.Party;
import com.example.util.JpaUtil;

import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager =
                JpaUtil.getEntityManagerFactory()
                        .createEntityManager();

        try {

            entityManager.getTransaction().begin();

            // Create parties
            Party john = new Party(
                    "John",
                    "0712345678"
            );

            Party jane = new Party(
                    "Jane",
                    "0723456789"
            );

            // Save parties
            entityManager.persist(john);
            entityManager.persist(jane);

            // Cash-in
            CashInTransaction cashIn =
                    new CashInTransaction(
                            new BigDecimal("500.00"),
                            john,
                            jane
                    );

            entityManager.persist(cashIn);

            // Cash-out
            CashOutTransaction cashOut =
                    new CashOutTransaction(
                            new BigDecimal("200.00"),
                            jane,
                            john
                    );

            entityManager.persist(cashOut);

            entityManager.getTransaction().commit();

            System.out.println("Data saved successfully.");

            System.out.println(john);
            System.out.println(jane);

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {

            entityManager.close();

            JpaUtil.getEntityManagerFactory().close();
        }
    }
}