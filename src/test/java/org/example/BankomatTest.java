package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankomatTest {
       Bankomat bankomat = new Bankomat();
       List<Konto> bankKonton = new ArrayList<>();
       Anvandare user = new Anvandare("Jag", "987", (ArrayList<Konto>) bankKonton);


    @BeforeEach
    void BeforeEach(){
        System.out.println("Testing...");
        bankKonton.add(new Konto("123", 111));
        bankomat.users.add(user);
    }
    @AfterEach
    void AfterEach(){
        System.out.println("your test is completed!");
    }
    @Test
    void logInTest_userExist() {
        Anvandare result=bankomat.LogIn(user, bankomat.users);
        assertAll(()->assertEquals(result.getUsername(), user.getUsername()),
        ()->assertEquals(result.getPassword(), user.getPassword()));
    }
    @Test
    void logInTest_CorrectUserWrongPassword(){
        Anvandare userWrongPassword = new Anvandare("Jag", "789", (ArrayList<Konto>) bankKonton);
        Anvandare result=bankomat.LogIn(userWrongPassword, bankomat.users);

        assertNull(result);
    }
    @Test
    void logInTest_UserNotExisting(){
        Anvandare NonExistingUser = new Anvandare("Du", "789", (ArrayList<Konto>) bankKonton);
        Anvandare result=bankomat.LogIn(NonExistingUser, bankomat.users);

        assertNull(result);
    }
    @Test
    void checkAccountBalance_UserNotExistingWithExistingAccount() {
        List<Konto> noExistingAccounts = new ArrayList<>();
        Anvandare NonExistingUser = new Anvandare("Du", "789", (ArrayList<Konto>) noExistingAccounts);
        int result= bankomat.CheckAccountBalance(NonExistingUser, "123");

        assertEquals(0, result);
    }
    @Test
    void checkAccountBalance_PrintCorrectAccount() {
    int result= bankomat.CheckAccountBalance(user, "123");

    assertEquals(111, result);
    }
    @Test
    void checkAccountBalance_CorrectUserIncorrectAccount() {
        int result = bankomat.CheckAccountBalance(user, "456");
        assertEquals(0, result);
    }
    @Test
    void depositMoney_Functioning() {
        int result= bankomat.DepositMoney(new Konto("000",200),100).getSum() ;

        assertEquals(300, result);
    }
    @Test
    void depositMoney_OnlyAddingMoney() {
        int result= bankomat.DepositMoney(new Konto("000",200),-100).getSum() ;

        assertEquals(200, result);
    }
    @Test
    void depositMoney_DepositMoreThanIntegerCanStore(){
        int result= bankomat.DepositMoney(new Konto("000",200),Integer.MAX_VALUE+1).getSum() ;

        assertEquals(200, result);
    }
    @Test
    void WithdrawMoney_Functioning(){
        int result= bankomat.WithdrawMoney(new Konto("000",200),100).getSum() ;

        assertEquals(100, result);
    }
    @Test
    void WithdrawMoney_NoMoneyToWithdraw(){
        int result= bankomat.WithdrawMoney(new Konto("000",200),300).getSum() ;

        assertEquals(200, result);
    }
    @Test
    void withdrawMoney_CanNotDepositMoney() {
        int a= -300;
        int result= bankomat.WithdrawMoney(new Konto("000",200),a).getSum() ;

        assertEquals(200, result);

    }
}