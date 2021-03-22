package com.Bank;

import java.util.ArrayList;

public abstract class Client {
    protected String name;
    protected ArrayList<Account> accounts = new ArrayList<Account>();

    public void addAccount(int sum){
        this.accounts.add(new Account(sum));
    }

    public int checkAllAccounts(){
        int sum = 0;
        for (Account acc : this.accounts){
            sum += acc.getBalance();
        }
        return sum;
    }

    public abstract String getInfo();
}
