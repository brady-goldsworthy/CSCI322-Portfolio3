package com.example.portfolio3;

/*
    Brady Goldsworthy and Justin Dupre
    Portfolio 3
    2/18/19
 */

public class Burger {

    //constants
    static final int    BEEF = 90,
                        TURKEY = 170,
                        VEGGIE = 150,
                        CHEDDAR = 113,
                        MOZZ = 78,
                        BACON = 86;

    //data members
    private int pattyCals, cheeseCals, baconCals, sauceCals;

    //Constructor
    public Burger() {
        pattyCals = BEEF;
        cheeseCals = 0;
        baconCals = 0;
        sauceCals = 0;
    }

    //Set methods
    public void setPattyCals(int pattyCals) {
        this.pattyCals = pattyCals;
    }

    public void setCheeseCals(int cheeseCals) {
        this.cheeseCals = cheeseCals;
    }

    public void setBaconCals(boolean isBacon) {

        if (isBacon) {
            baconCals = BACON;
        }
        else baconCals = 0;
    }

    public void setSauceCals(int sauceCals) {
        this.sauceCals = sauceCals;
    }

    //Calc total cals
    public int totalCals() {
        return pattyCals + cheeseCals + baconCals + sauceCals;
    }

}
