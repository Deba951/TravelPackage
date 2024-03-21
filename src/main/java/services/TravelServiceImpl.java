package main.java.services;

import main.java.models.Activity;
import main.java.models.Passenger;
import main.java.models.TravelPackage;
import main.java.models.Destination;
import main.java.models.GoldPassenger;
import main.java.models.StandardPassenger;

import java.util.List;

public class TravelServiceImpl implements TravelService {

    @Override
    public void printItinerary(TravelPackage travelPackage) {
        System.out.println("Travel Package Name: " + travelPackage.getName());
        System.out.println("Total Passenger Capacity: " + travelPackage.getPassengerCapacity());
        List<String> passengerList = travelPackage.getPassengerList();
        System.out.println("Passenger List:");
        for (String passenger : passengerList) {
            System.out.println(passenger);
        }
        List<Destination> destinations = travelPackage.getItinerary();
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getActivities();
            for (Activity activity : activities) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
        }
    }

    @Override
    public void printPassengerList(TravelPackage travelPackage) {
        System.out.println("Travel Package Name: " + travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        System.out.println("Passenger List:");
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    @Override
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            System.out.println("Balance: " + standardPassenger.getBalance());
        } else if (passenger instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) passenger;
            System.out.println("Balance: " + goldPassenger.getBalance());
        }
        List<Activity> activities = passenger.getActivities();
        System.out.println("Activities:");
        for (Activity activity : activities) {
            System.out.println("Activity: " + activity.getName());
            System.out.println("Destination: " + activity.getDestination().getName());
            System.out.println("Price Paid: " + activity.getPricePaid()); // Updated method call
        }
    }

    @Override
    public void printAvailableActivities(TravelPackage travelPackage) {
        System.out.println("Available Activities:");
        List<Activity> availableActivities = travelPackage.getAvailableActivities();
        for (Activity activity : availableActivities) {
            System.out.println("Activity: " + activity.getName());
            System.out.println("Destination: " + activity.getDestination().getName());
            System.out.println("Remaining Capacity: " + activity.getRemainingCapacity()); // Updated method call
        }
    }

    @Override
    public void signUpForActivity(Passenger passenger, String activityName, String destinationName) {
        List<Activity> activities = passenger.getActivities();
        for (Activity activity : activities) {
            if (activity.getName().equals(activityName) && activity.getDestination().getName().equals(destinationName)) {
                System.out.println("Passenger already signed up for this activity.");
                return;
            }
        }
        TravelPackage travelPackage = passenger.getTravelPackage();
        List<Activity> availableActivities = travelPackage.getAvailableActivities();
        for (Activity activity : availableActivities) {
            if (activity.getName().equals(activityName) && activity.getDestination().getName().equals(destinationName)) {
                if (activity.getRemainingCapacity() > 0) {
                    activity.setPricePaid(activity.getCost());
                    activities.add(activity);
                    System.out.println("Passenger signed up for activity.");
                    return;
                } else {
                    System.out.println("Activity is full. Cannot sign up.");
                    return;
                }
            }
        }
        System.out.println("Activity not found.");
    }

    @Override
    public void cancelActivitySignUp(Passenger passenger, String activityName, String destinationName) {

    }

    @Override
    public double getTotalCostForPassenger(Passenger passenger) {
        return 0;
    }
}