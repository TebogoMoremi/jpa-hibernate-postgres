package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cash_out_transactions")
public class CashOutTransaction extends Transaction {

    public CashOutTransaction() {
    }

    public CashOutTransaction(
            BigDecimal amount,
            Party initiator,
            Party receiver) {

        super(amount, initiator, receiver);
    }
}