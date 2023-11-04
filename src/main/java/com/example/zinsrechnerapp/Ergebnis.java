package com.example.zinsrechnerapp;


import java.util.ArrayList;
import java.util.List;

public class Ergebnis {

    private final List<OutputTable> outputTables = new ArrayList<>();

    public Ergebnis(double anfangskapital, double zinssatz, int laufzeit){
        getTableOutputs(anfangskapital,laufzeit,zinssatz);
    }


    private double getZinsFaktor(double zinssatz){
        return zinssatz / 100;
    }
    private double getZinsen(double anfangskapital, double zinssatzFaktor) {
        return anfangskapital * zinssatzFaktor;
    }
    private double getEndKapital(double anfangskapital, double zinssatz){
        return anfangskapital + getZinsen(anfangskapital, getZinsFaktor(zinssatz));
    }

    private double getRound(double number){
        return (double) Math.round(number * 100) / 100;
    }

    public List<OutputTable> getTableOutputs(double anfangskapital,int laufzeit, double zinssatz){
        for (int i = 1; i <= laufzeit; i++) {
            outputTables.add(new OutputTable(i,getRound(anfangskapital),
                    getRound(getZinsen(anfangskapital,getZinsFaktor(zinssatz))),
                    getRound(getEndKapital(anfangskapital, zinssatz))));
            anfangskapital = getEndKapital(anfangskapital, zinssatz);
        }
        return outputTables;
    }


    public List<OutputTable> getOutputTables() {
        return outputTables;
    }

}
