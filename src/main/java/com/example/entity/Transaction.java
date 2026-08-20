package com.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "initiator_id", nullable = false)
    private Party initiator;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receiver_id", nullable = false)
    private Party receiver;

    public Transaction() {
    }

    public Transaction(
            BigDecimal amount,
            Party initiator,
            Party receiver) {

        this.amount = amount;
        this.initiator = initiator;
        this.receiver = receiver;
        this.transactionDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Party getInitiator() {
        return initiator;
    }

    public Party getReceiver() {
        return receiver;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setInitiator(Party initiator) {
        this.initiator = initiator;
    }

    public void setReceiver(Party receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", initiator=" + initiator.getName() +
                ", receiver=" + receiver.getName() +
                '}';
    }
}