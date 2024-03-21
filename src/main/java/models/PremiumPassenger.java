package main.java.models;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, 0); // Premium passengers have no balance as they can sign up for free
    }

    @Override
    public boolean canSignUp(Activity activity) {
        return true; // Premium passengers can sign up for any activity
    }
}
