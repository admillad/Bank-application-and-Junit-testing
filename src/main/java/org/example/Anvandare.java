package org.example;

import java.util.ArrayList;

public class Anvandare {
    public String username;
    public String password;
    public ArrayList<Konto> account;
    public Anvandare(String username, String password, ArrayList<Konto> account) {
        this.account = account;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public ArrayList<Konto> getAccount() {
        return account;
    }
}
