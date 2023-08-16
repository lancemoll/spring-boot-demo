package com.xkcoding.deadlock;

import java.math.BigDecimal;

public class Account {

    private long userId;

    private BigDecimal amount;

    public Account() {
    }

    public Account(long userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void debit(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }



    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
