package tests.java.models;

import main.java.models.Activity;
import main.java.models.Passenger;
import main.java.models.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelPackageTest {
    private TravelPackage travelPackage;

    @BeforeEach
    public void setUp() {
        travelPackage = new TravelPackage("Test Package", 5);
    }

    @Test
    public void testAddPassenger() {
        Passenger passenger = new Passenger("Test Passenger", 1, 100.0) {
            @Override
            public boolean canSignUp(Activity activity) {
                return true;
            }
        };
        travelPackage.addPassenger(passenger);
        assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    public void testGetAvailableActivities() {
        // Assuming activities are properly added to destinations
        assertEquals(0, travelPackage.getAvailableActivities().size());
    }
}