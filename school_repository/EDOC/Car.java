package com.EDOC;

/**
 * Třída Car
 * Dědí se z abstraktní třídy Vehicle
 * Specifikuje některé parametry, které ostatní prostředky nemají.
 * Slouží jako ukázka dědičnosti, polymorfismu, implementace Interface
 *
 * @see Vehicle
 */
public class Car extends Vehicle {
    /**
     * Počet dveří ve vozidle
     */
    private final int doorCount = 4;
    /**
     * Zrychlení vozidla za 1s
     */
    private final int acceleration = 10;

    /**
     * Pole typu int s daty o otevřenosti dveří u auta
     * Obsahuje data typu true / false
     */
    private boolean[] openedDoors = new boolean[doorCount];
    /**
     * Pole typu String s daty osov ve vozidle
     *
     * 1. pozice: řidič
     * 2. pozice: spolujezdec
     * 3. pozice: osoba sedící vzadu vlevo
     * 4. pozice: osoba sedící uprostřed vzadu
     * 5. pozice: osoba sedící vzadu napravo
     *
     * + indexace (i - 1)
     */
    private String[] seats = new String[5];

    /**
     * Parametr typu String
     * Uchovává značku auta
     */
    private String carTag;

    /**
     * Jedná se o konstruktor třídy Car
     * zavolá construktor třídy vehilce s parametry:
     *
     * @param weight váha auta
     * @param name  pojmenování auta
     */
    public Car(int weight, String name) {
        super(weight, name);
    }

    /**
     * Metoda ukládá informace o dveřích. Zda jsou zavřené nebo otevřené.
     *
     * @param LZ Levá zadní
     * @param LP Levá přední
     * @param PZ Pravá zadní
     * @param PP Pravá přední
     */
    public void openDoors(boolean LZ, boolean LP, boolean PZ, boolean PP) {
        this.openedDoors[0] = LZ;
        this.openedDoors[1] = LP;
        this.openedDoors[2] = PZ;
        this.openedDoors[3] = PP;
    }

    /**
     * Metoda nastaví osoby v autě (přetížení metod)
     *
     * @param driver    nastaví jméno řidiče
     * @param coDriver  nastaví jméno spolujezdce
     * @param backSeat1 nastaví jméno osoby na pozici 1
     * @param backSeat2 nastaví jméno osoby na pozici 2
     * @param backSeat3 nastaví jméno osoby na pozici 3
     *                  <p>
     *                  Ukázka přetížení metod.
     */
    public void setPassengers(String driver, String coDriver, String backSeat1, String backSeat2, String backSeat3) {
        this.seats[0] = driver;
        this.seats[1] = coDriver;
        this.seats[2] = backSeat1;
        this.seats[3] = backSeat2;
        this.seats[4] = backSeat3;
    }

    /**
     * Metoda nastaví osoby v autě
     *
     * @param driver    nastaví jméno řidiče
     * @param coDriver  nastaví jméno spolujezdce
     * @param backSeat1 nastaví jméno osoby na pozici 1
     * @param backSeat2 nastaví jméno osoby na pozici 2
     *                  <p>
     *                  3. pozice osoby se nuluje
     */
    public void setPassengers(String driver, String coDriver, String backSeat1, String backSeat2) {
        this.setPassengers(driver, coDriver, backSeat1, backSeat2, "");
    }

    /**
     * Metoda nastaví osoby v autě
     *
     * @param driver    nastaví jméno řidiče
     * @param coDriver  nastaví jméno spolujezdce
     * @param backSeat1 nastaví jméno osoby na pozici 1
     *                  <p>
     *                  2. pozice osoby se nuluje
     *                  3. pozice osoby se nuluje
     */
    public void setPassengers(String driver, String coDriver, String backSeat1) {
        this.setPassengers(driver, coDriver, backSeat1, "", "");
    }

    /**
     * Metoda nastaví osoby v autě
     *
     * @param driver   nastaví jméno řidiče
     * @param coDriver nastaví jméno spolujezdce
     *                 <p>
     *                 1. pozice osoby se nuluje
     *                 2. pozice osoby se nuluje
     *                 3. pozice osoby se nuluje
     */
    public void setPassengers(String driver, String coDriver) {
        this.setPassengers(driver, coDriver, "", "", "");
    }

    /**
     * Metoda nastaví osoby v autě
     *
     * @param driver nastaví jméno řidiče
     *               <p>
     *               pozice spolujezdce se nuluje
     *               1. pozice osoby se nuluje
     *               2. pozice osoby se nuluje
     *               3. pozice osoby se nuluje
     */
    public void setPassengers(String driver) {
        this.setPassengers(driver, "", "", "", "");
    }

    /**
     * Metoda uloží značku auta do paměti
     *
     * @param tag obsahuje značku auta
     */
    @Override
    public void setTag(String tag) {
        this.carTag = carTag;
    }

    /**
     * Metoda, která vytvoří textový řetězec z osob ve vozidle
     *
     * @return vrací String osob
     */
    @Override
    public String getPassengers() {
        StringBuilder builder = new StringBuilder();
        for (String name : this.seats) {
            builder.append(name).append(" ");
        }
        return builder.toString();
    }

    /**
     * Zrychlení vozidla
     */
    @Override
    public void increaseSpeed() {
        this.speed += acceleration;
    }

    /**
     * Zpomalení pozidla
     */
    @Override
    public void decreaseSpeed() {
        this.speed -= acceleration;
    }
}