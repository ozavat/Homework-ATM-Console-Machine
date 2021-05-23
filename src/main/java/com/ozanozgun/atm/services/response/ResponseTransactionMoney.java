package com.ozanozgun.atm.services.response;

public class ResponseTransactionMoney {


    private float responseAmount;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public float getResponseAmount() {
        return responseAmount;
    }

    public void setResponseAmount(float responseAmount) {
        this.responseAmount = responseAmount;
    }

}
