package main.java.models;

public class StandardPassenger extends Passenger {
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    @Override
    public boolean canSignUp(Activity activity) {
        return getBalance() >= activity.getCost();
    }
}
