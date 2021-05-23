package com.ozanozgun.atm.customer;

public class BireyselMusteri extends Musteri{

    private String homeAddress;

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public BireyselMusteri(String tcNo,String accountNo, String nameSuname, float accountBalance,String homeAddress) {
        this.setTcNo(tcNo);
        this.setAccountNo(accountNo);
        this.setNameSurname(nameSuname);
        this.setAccountBalance(accountBalance);
        this.homeAddress = homeAddress;
    }


    @Override
    public String toString() {
        return "Müsterinin Adı: "+ getNameSurname()+ '\n' + "Müşteri Tc Kimlik Numarası: "+getTcNo()+'\n'+"Hesap Bakiyesi: " + getAccountBalance()+ "₺"+'\n'+ "Bireysel Müşteri Ev Adresi: "+getHomeAddress()+ '\n';

    }
}
