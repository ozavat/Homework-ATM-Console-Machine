package com.ozanozgun.atm;

import com.ozanozgun.atm.customer.BireyselMusteri;
import com.ozanozgun.atm.customer.KurumsalMusteri;
import com.ozanozgun.atm.customer.Musteri;
import com.ozanozgun.atm.services.MoneyTransferService;
import com.ozanozgun.atm.services.request.RequestTransactionMoney;
import com.ozanozgun.atm.services.response.ResponseTransactionMoney;

import java.util.HashMap;
import java.util.Scanner;

public class AtmMain {


    public static void main(String[] args) {

        BireyselMusteri musteriA = new BireyselMusteri("11111111111", "1", "Ozan Özgün", 8000.75F, "Kadıköy");
        BireyselMusteri musteriB = new BireyselMusteri("2222222222", "2", "Yavuz Çetin", 88888F, "Caddebostan");
        BireyselMusteri musteriC = new BireyselMusteri("3333333333", "3", "Mırmır Kedibıyık", 456.50F, "Kedi Evi Sokak İstanbul");
        KurumsalMusteri musteriD = new KurumsalMusteri("4444444444", "4", "Mehmet Besthoca", 8888143F, "Testinium");
        KurumsalMusteri musteriE = new KurumsalMusteri("5555555555", "5", "Serhat Yücel", 120.5F, "Ozan Holding");

        /*Burada musterilere ulaşmak isterken bazı senaryolarda TypeCasting yapmam gerekecek.
          Eğer iki farklı HashMap kullanırsam müsteri türleri için TypeCasting kullanmama gerek kalmaz. */
        HashMap<String, Musteri> musterilerHashMap = new HashMap<String, Musteri>();
        musterilerHashMap.put(musteriA.getAccountNo(), musteriA);
        musterilerHashMap.put(musteriB.getAccountNo(), musteriB);
        musterilerHashMap.put(musteriC.getAccountNo(), musteriC);
        musterilerHashMap.put(musteriD.getAccountNo(), musteriD);
        musterilerHashMap.put(musteriE.getAccountNo(), musteriE);

        Scanner sc = new Scanner(System.in);
        String costumerId = getIdFromConsole(sc);

        if (musterilerHashMap.get(costumerId) instanceof BireyselMusteri) {
            BireyselMusteri musteri = ((BireyselMusteri) musterilerHashMap.get(costumerId));
            System.out.println(musteri.toString());
        } else {
            try {
                KurumsalMusteri musteri = ((KurumsalMusteri) musterilerHashMap.get(costumerId));
                System.out.println(musteri.toString());
            } catch (Exception e) {
                System.out.println("Müşteri bilgileri alınırken hata oluştu!");
                System.out.println(e.getMessage());
            }
        }

        String transactionType = getTransactionTypeFromConsole(sc);

        MoneyTransferService moneyTransferService = new MoneyTransferService();
        RequestTransactionMoney requestTransactionMoney = new RequestTransactionMoney();
        requestTransactionMoney.setAccountBalance(musterilerHashMap.get(costumerId).getAccountBalance());
        ResponseTransactionMoney responseTransactionMoneyMoney = null;


        if ("1".equals(transactionType)) {
            float transactionAmount = getTransactionAmountFromConsole(sc);

            requestTransactionMoney.setTransactionAmount(transactionAmount);
            responseTransactionMoneyMoney = moneyTransferService.depositMoney(requestTransactionMoney);
        } else if ("2".equals(transactionType)) {
            float transactionAmount = getTransactionAmountFromConsole(sc);

            requestTransactionMoney.setTransactionAmount(transactionAmount);
            responseTransactionMoneyMoney = moneyTransferService.withdrawMoney(requestTransactionMoney);
        }

        if (responseTransactionMoneyMoney != null) {

            if (responseTransactionMoneyMoney.getErrorMessage() != null) {
                System.out.println(responseTransactionMoneyMoney.getErrorMessage());
            } else {
                musterilerHashMap.get(costumerId).setAccountBalance(responseTransactionMoneyMoney.getResponseAmount());
                System.out.println("İşleminiz gerçekleştirildi!" + '\n' + "Yeni hesap bakiyesi: " + musterilerHashMap.get(costumerId).getAccountBalance());
            }
        }
    }

    private static String getIdFromConsole(Scanner sc) {
        String input;
        do {
            System.out.println("Lütfen müsteri numarasını doğru bir şekilde giriniz!!");
            System.out.println("Hint; (1,2,3,4,5)");
            input = sc.nextLine();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));  //
        return input;
    }

    private static String getTransactionTypeFromConsole(Scanner sc) {
        String input;
        do {
            System.out.println("Para yatırmak için 1" + '\n' + "Para çekmek için 2" + '\n' + "Yazınız!");
            input = sc.nextLine();
        } while (!input.equals("1") && !input.equals("2"));  //
        return input;
    }

    private static Float getTransactionAmountFromConsole(Scanner sc) {
        String input;
        boolean checkInput = false;
        float floatInput = 0;

        do {
            System.out.println("Lütfen işlem miktarını giriniz");
            input = sc.nextLine();
            try {
                floatInput = Float.parseFloat(input);
                if (floatInput <= 0) {
                    System.out.println("İşlem mikatarı sıfır ve sıfırdan küçük olamaz!!");
                } else {
                    checkInput = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!checkInput);
        return floatInput;
    }
}
