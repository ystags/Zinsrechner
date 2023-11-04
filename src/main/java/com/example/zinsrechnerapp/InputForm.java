package com.example.zinsrechnerapp;

import jakarta.validation.constraints.Positive;

public class InputForm {
    private @Positive(message = "muss größer als 0 sein") double anfangskapital;
    private  @Positive(message = "muss größer als 0 sein") int laufzeit;
    private  @Positive(message = "muss größer als 0 sein") double zinssatz;

    private boolean showTable;

    public double getAnfangskapital() {
        return anfangskapital;
    }

    public void setAnfangskapital(double anfangskapital) {
        this.anfangskapital = anfangskapital;
    }

    public int getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(int laufzeit) {
        this.laufzeit = laufzeit;
    }

    public double getZinssatz() {
        return zinssatz;
    }

    public void setZinssatz(double zinssatz) {
        this.zinssatz = zinssatz;
    }

    public boolean isShowTable() {
        return showTable;
    }

    public void setShowTable(boolean showTable) {
        this.showTable = showTable;
    }
}
