package main;
import main.java.models.*;
import main.java.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // sample travel package with destinations and activities
        TravelPackage travelPackage = createSampleTravelPackage();

        // dummy passengers to the travel package
        addDummyPassengers(travelPackage);

        TravelService travelService = new TravelServiceImpl();

        System.out.println("Welcome to the Travel Agency System!");
        System.out.println("1. Print Itinerary");
        System.out.println("2. Print Passenger List");
        System.out.println("3. Print Passenger Details");
        System.out.println("4. Print Available Activities");
        System.out.println("5. Exit");

        boolean exit = false;
        while (!exit) {
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    travelService.printItinerary(travelPackage);
                    break;
                case 2:
                    travelService.printPassengerList(travelPackage);
                    break;
                case 3:
                    System.out.print("Enter passenger number: ");
                    int passengerNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    Passenger passenger = findPassengerByNumber(travelPackage, passengerNumber);
                    if (passenger != null) {
                        travelService.printPassengerDetails(passenger);
                    } else {
                        System.out.println("Passenger not found.");
                    }
                    break;
                case 4:
                    travelService.printAvailableActivities(travelPackage);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static TravelPackage createSampleTravelPackage() {
        // Create destinations and activities
        Destination destination1 = new Destination("Paris");
        Activity activity1 = new Activity("Eiffel Tower Tour", "Visit the iconic Eiffel Tower", 50.0, 20, destination1);
        Activity activity2 = new Activity("Louvre Museum Visit", "Explore the famous Louvre Museum", 40.0, 30, destination1);
        destination1.addActivity(activity1);
        destination1.addActivity(activity2);

        Destination destination2 = new Destination("Rome");
        Activity activity3 = new Activity("Colosseum Tour", "Discover the ancient Colosseum", 60.0, 25, destination2);
        destination2.addActivity(activity3);

        // Create travel package and add destinations
        TravelPackage travelPackage = new TravelPackage("European Tour", 50);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        return travelPackage;
    }

    private static Passenger findPassengerByNumber(TravelPackage travelPackage, int passengerNumber) {
        for (Passenger passenger : travelPackage.getPassengers()) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                return passenger;
            }
        }
        return null;
    }

    private static void addDummyPassengers(TravelPackage travelPackage) {
        String[] names = {"John Doe", "Jane Smith", "Michael Johnson", "Emily Davis", "David Wilson",
                "Sarah Martinez", "Robert Anderson", "Jennifer Taylor", "William Thomas", "Olivia Moore"};

        for (int i = 0; i < names.length; i++) {
            Passenger passenger;
            if (i % 3 == 0) {
                passenger = new GoldPassenger(names[i], i + 1, 500.0); // Dummy balance for gold passengers
            } else if (i % 2 == 0) {
                passenger = new PremiumPassenger(names[i], i + 1);
            } else {
                passenger = new StandardPassenger(names[i], i + 1, 300.0); // Dummy balance for standard passengers
            }
            travelPackage.addPassenger(passenger);
        }
    }

}
