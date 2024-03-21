package tests.java.models;

import main.java.models.Activity;
import main.java.models.Destination;
import main.java.models.Passenger;
import main.java.models.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest {
    private Activity activity;

    @BeforeEach
    public void setUp() {
        Destination destination = new Destination("Test Destination");
        activity = new Activity("Test Activity", "Activity description", 100.0, 10, destination);
    }

    @Test
    public void testGetRemainingCapacity() {
        assertEquals(10, activity.getRemainingCapacity());
        activity.getDestination().getActivities().add(activity); // Simulate signing up
        assertEquals(9, activity.getRemainingCapacity());
    }
}