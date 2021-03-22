package com.Bank;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Client> clientList = new ArrayList<>();

        Person pekar = new Person("Pekar");
        pekar.addAccount(1000);
        pekar.addAccount(500);
        clientList.add(pekar);

        Person svecova = new Person("Svecova");
        svecova.addAccount(1200);
        clientList.add(svecova);

        Company skoda = new Company("Skoda");
        skoda.addAccount(120);
        clientList.add(skoda);

        for(Client client: clientList){
            System.out.println(client.getInfo() + " || " + client.checkAllAccounts());
        }
    }
}
