package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cash_in_transactions")
public class CashInTransaction extends Transaction {

    public CashInTransaction() {
    }

    public CashInTransaction(
            BigDecimal amount,
            Party initiator,
            Party receiver) {

        super(amount, initiator, receiver);
    }
}