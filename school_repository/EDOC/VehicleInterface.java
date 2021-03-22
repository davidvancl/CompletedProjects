package com.EDOC;

/**
 * VehicleInterface je interface definující vzhled tříd ketré ho implementují
 */
interface VehicleInterface {
    /**
     * Metoda pro zrychlení vozidla.
     */
    void increaseSpeed();
    /**
     * Metoda pro zpomalení vozidla.
     */
    void decreaseSpeed();
    /**
     * Metoda pro výpis osob z vozidla
     */
    String getPassengers();
    /**
     * Metoda pro nastavení značky vozidla
     */
    void setTag(String tag);
}
