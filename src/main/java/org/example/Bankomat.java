package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bankomat {
    Bank bank = new Bank();
    List<Anvandare> users = new ArrayList<>();
    Anvandare CurrentUser;

    public void createUser() {
        ArrayList<Konto> mattesKonto= new ArrayList<>();
        Konto mattesKonto1 = new Konto("123",101010 );
        mattesKonto.add(mattesKonto1);
        Anvandare user1 = new Anvandare("matte", "qwe", mattesKonto);

        ArrayList<Konto> tildasKonto= new ArrayList<>();
        Konto tildasKonto1 = new Konto("987",908070 );
        tildasKonto.add(tildasKonto1);
        Anvandare user2 = new Anvandare("tilda", "asd", tildasKonto);

        users.add(user1);
        users.add(user2);
    }

    public void run() {
        createUser();
        System.out.println("Welcome please log in to see your account");
        String username = ScannerClass.ScannerHelper.getString("Enter username: ");
        String password = ScannerClass.ScannerHelper.getString("Enter password:  ");
        CurrentUser = LogIn(new Anvandare(username, password, null),users);
        if(CurrentUser==null){
            System.out.println("Wrong username or password, access denied.");
            System.exit(1);
        } else {
            System.out.println("Welcome" + "" +CurrentUser.getUsername() + "access granted!");

        }
    }
    public Anvandare LogIn(Anvandare LogIn, List<Anvandare> users){
        for(Anvandare a: this.users) {
            if (a.getUsername().equals(LogIn.getUsername())) {
                if (a.getPassword().equals(LogIn.getPassword())) {
                    return a;
                }
            }
        }
        return null;
    }
    public int CheckAccountBalance(Anvandare CurrentUser, String accountNumber) {
        for (Konto balans : CurrentUser.getAccount()) {
            if (balans.getAccountNumber().equals(accountNumber)) {
                return balans.getSum();
            }
        }
        return 0;
    }
    public Konto DepositMoney(  Konto account, Integer addMoney) {
        Integer currentAmount = account.sum;
        Integer totalAmount = currentAmount+addMoney;
        if(totalAmount<currentAmount){
            System.out.println("You can only deposit money, please try again");
        return account;}
        if(totalAmount>Integer.MAX_VALUE){
            System.out.println("You cannot deposit that much money, try again ");
            return account;
        }
        account.setSum(totalAmount);
        System.out.println("You have deposit your money! Current balance is:" + account.getSum());
        return account;

    }
    public Konto WithdrawMoney(Konto account, Integer submoney) {
        Integer currentAmount = account.sum;
        Integer totalAmount = currentAmount-submoney;
        if (totalAmount > currentAmount) {
            System.out.println("You can only withdraw money, please try again");
            return account;}
        if (totalAmount < submoney){
            System.out.println("Not enough money in account, you have: " + currentAmount);
            return account;}
        account.setSum(totalAmount);
        System.out.println("You have withdraw some money! Current balance is:" + account.getSum());
            return account;
        }

    }

