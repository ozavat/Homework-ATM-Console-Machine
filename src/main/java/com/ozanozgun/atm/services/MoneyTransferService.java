package com.ozanozgun.atm.services;

import com.ozanozgun.atm.services.request.RequestTransactionMoney;
import com.ozanozgun.atm.services.response.ResponseTransactionMoney;

public class MoneyTransferService {


    public ResponseTransactionMoney depositMoney(RequestTransactionMoney depositMoney) {

        float accountBalance = depositMoney.getAccountBalance();
        float depositAmount = depositMoney.getTransactionAmount();
        float responseAmount = accountBalance + depositAmount;

        ResponseTransactionMoney response = new ResponseTransactionMoney();
        response.setResponseAmount(responseAmount);
        return response;
    }


    public ResponseTransactionMoney withdrawMoney(RequestTransactionMoney withdrawMoney){

        float accountBalance = withdrawMoney.getAccountBalance();
        float withdrawAmount = withdrawMoney.getTransactionAmount();
        ResponseTransactionMoney respose = new ResponseTransactionMoney();

        if (accountBalance<withdrawAmount){
            respose.setErrorMessage("Hesap bakiyesi yetersiz! Bu ATM kendini imha edecektir! ");
            return respose;
        }

        try {
           float responseAmount =  accountBalance-withdrawAmount;
           respose.setResponseAmount(responseAmount);
           return  respose;
        }catch (Exception e){
            return null;
        }
    }
}
