package com.ozanozgun.atm.customer;

public class KurumsalMusteri extends Musteri{

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public KurumsalMusteri(String tcNo,String accountNo, String nameSuname, float accountBalance,String companyName) {
        this.setTcNo(tcNo);
        this.setAccountNo(accountNo);
        this.setNameSurname(nameSuname);
        this.setAccountBalance(accountBalance);
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Müsterinin Adı: "+ getNameSurname()+ '\n' + "Müşteri Tc Kimlik Numarası: "+getTcNo()+'\n'+"Hesap Bakiyesi: " + getAccountBalance()+ "₺"+'\n'+ "Kurumsal Müşteri Şirket Adı: "+getCompanyName()+ '\n';
    }
}
