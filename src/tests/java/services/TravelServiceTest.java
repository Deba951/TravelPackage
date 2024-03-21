package tests.java.services;

import main.java.models.*;
import main.java.services.TravelService;
import main.java.services.TravelServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TravelServiceTest {
    private TravelService travelService;
    private TravelPackage travelPackage;
    private Passenger passenger;
    private PrintStream originalSystemOut;

    @BeforeEach
    public void setUp() {
        travelService = new TravelServiceImpl();
        travelPackage = new TravelPackage("Test Package", 5);
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Activity description", 100.0, 10, destination);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);
        passenger = new StandardPassenger("Test Passenger", 1, 200.0);
        travelPackage.addPassenger(passenger);
        // Store the original System.out to reset it after capturing output
        originalSystemOut = System.out;
    }

    @Test
    public void testPrintItinerary() throws FileNotFoundException {
        // Create a StringWriter to capture printed output
        StringWriter sw = new StringWriter();
        // PrintWriter pw = new PrintWriter(sw);
        PrintStream pw = new PrintStream(String.valueOf(sw));
        System.setOut(pw); // Redirect System.out to the StringWriter

        travelService.printItinerary(travelPackage);

        // Reset System.out to console
        System.setOut(originalSystemOut);

        // Reset System.out to console
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        // Check if the captured output contains expected strings
        String printedOutput = sw.toString();
        assertTrue(printedOutput.contains("Travel Package Name: Test Package"));
        assertTrue(printedOutput.contains("Destination: Test Destination"));
        assertTrue(printedOutput.contains("Activity: Test Activity"));
        // Add more specific assertions as needed based on expected output
    }


    @Test
    public void testPrintPassengerList() throws FileNotFoundException {
        // Create a StringWriter to capture printed output
        StringWriter sw = new StringWriter();
        // PrintWriter pw = new PrintWriter(sw);
        PrintStream pw = new PrintStream(String.valueOf(sw));
        System.setOut(pw); // Redirect System.out to the StringWriter

        travelService.printPassengerList(travelPackage);

        // Reset System.out to console
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        // Check if the captured output contains expected strings
        String printedOutput = sw.toString();
        assertTrue(printedOutput.contains("Travel Package Name: Test Package"));
        assertTrue(printedOutput.contains("Passenger Capacity: 5"));
        assertTrue(printedOutput.contains("Number of Passengers Enrolled: 1"));
        assertTrue(printedOutput.contains("Name: Test Passenger"));
        // Add more specific assertions as needed based on expected output
    }


    @Test
    public void testPrintPassengerDetails() throws FileNotFoundException {
        // Create a StringWriter to capture printed output
        StringWriter sw = new StringWriter();
        // PrintWriter pw = new PrintWriter(sw);
        PrintStream pw = new PrintStream(String.valueOf(sw));
        System.setOut(pw); // Redirect System.out to the StringWriter

        travelService.printPassengerDetails(passenger);

        // Reset System.out to console
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        // Check if the captured output contains expected strings
        String printedOutput = sw.toString();
        assertTrue(printedOutput.contains("Passenger Name: Test Passenger"));
        assertTrue(printedOutput.contains("Passenger Number: 1"));
        assertTrue(printedOutput.contains("Balance: 200.0"));
        assertTrue(printedOutput.contains("Activity: Test Activity"));
        assertTrue(printedOutput.contains("Destination: Test Destination"));
        assertTrue(printedOutput.contains("Price Paid: 100.0")); // Assuming the activity cost is 100.0
        // Add more specific assertions as needed based on expected output
    }


    @Test
    public void testPrintAvailableActivities() throws FileNotFoundException {
        // Create a StringWriter to capture printed output
        StringWriter sw = new StringWriter();
        // PrintWriter pw = new PrintWriter(sw);
        PrintStream pw = new PrintStream(String.valueOf(sw));
        System.setOut(pw); // Redirect System.out to the StringWriter

        travelService.printAvailableActivities(travelPackage);

        // Reset System.out to console
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        // Check if the captured output contains expected strings
        String printedOutput = sw.toString();
        assertTrue(printedOutput.contains("Available Activities:"));
        assertTrue(printedOutput.contains("Activity: Test Activity"));
        assertTrue(printedOutput.contains("Destination: Test Destination"));
        assertTrue(printedOutput.contains("Remaining Capacity: 9")); // Assuming one passenger signed up
        // Add more specific assertions as needed based on expected output
    }


    @Test
    public void testSignUpForActivity() {
        travelService.signUpForActivity(passenger, "Test Activity", "Test Destination");

        // Check if the passenger's activities list contains the signed-up activity
        assertTrue(passenger.getActivities().stream()
                .anyMatch(activity -> activity.getName().equals("Test Activity")));
        // Add more specific assertions as needed based on expected changes
    }

    @Test
    public void testCancelActivitySignUp() {
        // First, sign up the passenger for an activity
        travelService.signUpForActivity(passenger, "Test Activity", "Test Destination");

        // Now, cancel the activity sign-up
        travelService.cancelActivitySignUp(passenger, "Test Activity", "Test Destination");

        // Check if the passenger's activities list does not contain the canceled activity
        assertFalse(passenger.getActivities().stream()
                .anyMatch(activity -> activity.getName().equals("Test Activity")));
        // Add more specific assertions as needed based on expected changes
    }

    @Test
    public void testGetTotalCostForPassenger() {
        // First, sign up the passenger for an activity
        travelService.signUpForActivity(passenger, "Test Activity", "Test Destination");

        // Get the total cost for the passenger
        double totalCost = travelService.getTotalCostForPassenger(passenger);

        // Check if the total cost matches the expected value
        assertEquals(100.0, totalCost); // Assuming the activity cost is 100.0
        // Add more specific assertions as needed based on expected total cost
    }

    @AfterEach
    public void restoreSystemOutStream() {
        // Restore the original System.out stream after the tests
        System.setOut(originalSystemOut);
    }

}

