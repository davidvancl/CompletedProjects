package com.Bank;

public class Account {
    private int balance = 0;

    public Account(int deposit){
        this.balance = deposit;
    }

    public Account(){}

    public boolean deposit(int deposit){
        this.balance += deposit;
        return true;
    }

    public boolean withdraw(int count){
        if((this.balance - count) >= 0){
            this.balance -= count;
            return true;
        } else {
            return false;
        }
    }

    public int getBalance(){
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + '}';
    }
}
