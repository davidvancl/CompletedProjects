package com.EDOC;

/**
 * Jedná se o abstraktní třídu Vehicle
 * Uchovává data sdílené pro více tříd, které dědí z této třídy.
 * Abstraktní = nelze instancovat
 *
 * Implementuje Interface VehicleInterface, který definuje nutné metody v děděných třídách.
 */
public abstract class Vehicle implements VehicleInterface {
    /**
     * Rychlost vozidla
     */
    protected int speed = 0;
    /**
     * Váha vozidla
     */
    protected int weight;
    /**
     * Barva vozidla
     */
    protected String color;
    /**
     * Jméno vozidla
     */
    protected String name;

    /**
     * Construktor volaný děděnými třídami s paramtery:
     *
     * @param weight váha
     * @param name jméno
     */
    public Vehicle(int weight,String name){
        this.weight = weight;
        this.name = name;
    }

    /**
     * Nastaví hmotnost vozidla
     * Typ proměnné: String
     *
     * @param weight hmotnost
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Nastaví barvu vozidla
     * Typ proměnné: String
     *
     * @param color barva
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Nastaví jméno vozidla
     * Typ proměnné: String
     *
     * @param name jméno
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Nastaví specifickou rychlost vozidla
     * Typ proměnné: int
     *
     * @param newSpeed nová rychlost
     */
    protected void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }
}
