package tests.java.models;

import main.java.models.Activity;
import main.java.models.GoldPassenger;
import main.java.models.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerTest {

    @Test
    public void testCanSignUp() {
        Activity activity = new Activity("Test Activity", "Activity description", 100.0, 10, null);
        Passenger standardPassenger = new GoldPassenger("Test Passenger", 1, 200.0); // Enough balance
        assertTrue(standardPassenger.canSignUp(activity));

        Passenger goldPassenger = new GoldPassenger("Test Passenger", 2, 50.0); // Not enough balance
        assertFalse(goldPassenger.canSignUp(activity));
    }
}