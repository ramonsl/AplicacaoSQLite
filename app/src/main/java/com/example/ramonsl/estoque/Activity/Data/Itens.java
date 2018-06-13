package com.example.ramonsl.estoque.Activity.Data;

import java.io.Serializable;

public class Itens  implements Serializable{

    private int mId;
    private String mName;
    private int mQtd;
    private double mPrice;
    private boolean mPerishable;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getQtd() {
        return mQtd;
    }

    public double getPrice() {
        return mPrice;
    }

    public boolean isPerishable() {
        return mPerishable;
    }

    public Itens(String mName, int mQtd, double mPrice, boolean mPerishable) {
        this.mName = mName;
        this.mQtd = mQtd;
        this.mPrice = mPrice;
        this.mPerishable = mPerishable;
    }

    public Itens(int mId, String mName, int mQtd, double mPrice, boolean mPerishable) {
        this.mId = mId;
        this.mName = mName;
        this.mQtd = mQtd;
        this.mPrice = mPrice;
        this.mPerishable = mPerishable;
    }


    @Override
    public String toString() {
        return  mName ;
    }
}
