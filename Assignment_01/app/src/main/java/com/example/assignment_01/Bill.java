package com.example.assignment_01;

public class Bill {
    double amount;
    int tip;

    public Bill(){

    }

    public Bill(double amount, int tip){

    }

    public double getAmount() {
        return amount;
    }

    public int getTip() {
        return tip;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
}
