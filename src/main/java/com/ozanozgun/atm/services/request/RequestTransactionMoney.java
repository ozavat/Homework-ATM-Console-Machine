package com.ozanozgun.atm.services.request;

public class RequestTransactionMoney {

    private float accountBalance;
    private float transactionAmount;


    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
