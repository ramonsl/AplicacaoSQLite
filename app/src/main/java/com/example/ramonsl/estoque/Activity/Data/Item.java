package com.example.ramonsl.estoque.Activity.Data;

import java.io.Serializable;

public class Item implements Serializable{

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

    public Item(String mName, int mQtd, double mPrice, boolean mPerishable) {
        this.mName = mName;
        this.mQtd = mQtd;
        this.mPrice = mPrice;
        this.mPerishable = mPerishable;
    }

    public Item(int mId, String mName, int mQtd, double mPrice, boolean mPerishable) {
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
