package com.Bank;

public class Company extends Client{
    public Company(String name){
        this.name = name;
    }

    public String getInfo(){
        return "firma " + this.name;
    }
}
