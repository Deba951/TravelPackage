package main.java.models;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    @Override
    public boolean canSignUp(Activity activity) {
        return getBalance() >= (activity.getCost() * 0.9); // 10% discount for gold passengers
    }
}
