package main.java.models;

import java.util.List;

public abstract class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private List<Activity> activities; // List to store signed-up activities


    public Passenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract boolean canSignUp(Activity activity);

    public TravelPackage getTravelPackage() {
        return TravelPackage.getInstance();
    }
}
