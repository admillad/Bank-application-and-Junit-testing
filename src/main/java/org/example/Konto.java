package org.example;

public class Konto {
public String accountNumber;
public int sum;

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Konto(String accountNumber, int sum) {
        this.accountNumber=accountNumber;
        this.sum=sum;
    }

}
