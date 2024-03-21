package tests.java.models;

import main.java.models.Activity;
import main.java.models.Destination;
import main.java.models.Passenger;
import main.java.models.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DestinationTest {
    private Destination destination;

    @BeforeEach
    public void setUp() {
        destination = new Destination("Test Destination");
    }

    @Test
    public void testAddActivity() {
        Activity activity = new Activity("Test Activity", "Activity description", 100.0, 10, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
    }

    @Test
    public void testRemoveActivity() {
        Activity activity = new Activity("Test Activity", "Activity description", 100.0, 10, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        destination.removeActivity(activity);
        assertEquals(0, destination.getActivities().size());
    }
}