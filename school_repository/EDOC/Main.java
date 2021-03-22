package com.EDOC;

/**
 * Tato aplikace slouží jako ukázka.
 * Poukazuje na dědičnost, polymorfismus, přetížení metod, implementace inerface
 * a práce s jednotlivými datovými typy
 *
 * @author David Vancl
 * @version 1.0
 * @since 2020-05-15
 */

public class Main {

    /**
     * Bod Spouštění aplikace
     *
     * Dojde k instancování třídy Car
     * nastaví se osoby do auta
     * dojde k zavření všech dveří
     * mužeme vyměmit značku auta
     *
     * @param args vstupní parametry aplikace
     */
    public static void main(String[] args) {
        Car auto = new Car(2,"Pepina");
        auto.setPassengers("Jarda","Pepa");
        auto.openDoors(false,false,false,false);
        auto.setTag("X26BFS5");
    }
}
