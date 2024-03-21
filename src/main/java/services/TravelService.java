package main.java.services;

import main.java.models.Passenger;
import main.java.models.TravelPackage;

public interface TravelService {
    /**
     * Print the itinerary of the given travel package, including details of destinations and activities.
     * @param travelPackage The travel package for which the itinerary should be printed.
     */
    void printItinerary(TravelPackage travelPackage);

    /**
     * Print the passenger list of the given travel package, including package details and passenger information.
     * @param travelPackage The travel package for which the passenger list should be printed.
     */
    void printPassengerList(TravelPackage travelPackage);

    /**
     * Print the details of an individual passenger, including their name, number, balance (if applicable),
     * and a list of activities they have signed up for.
     * @param passenger The passenger whose details should be printed.
     */
    void printPassengerDetails(Passenger passenger);

    /**
     * Print the details of all activities that still have spaces available in the given travel package,
     * including how many spaces are available for each activity.
     * @param travelPackage The travel package for which available activities should be printed.
     */
    void printAvailableActivities(TravelPackage travelPackage);

    /**
     * Sign up a passenger for a specific activity in the travel package.
     * @param passenger The passenger to sign up for the activity.
     * @param activityName The name of the activity to sign up for.
     * @param destinationName The name of the destination where the activity takes place.
     */
    void signUpForActivity(Passenger passenger, String activityName, String destinationName);

    /**
     * Cancel a passenger's signup for a specific activity in the travel package.
     * @param passenger The passenger to cancel the activity signup for.
     * @param activityName The name of the activity to cancel.
     * @param destinationName The name of the destination where the activity takes place.
     */
    void cancelActivitySignUp(Passenger passenger, String activityName, String destinationName);

    /**
     * Get the total cost of activities signed up by a passenger in the travel package.
     * @param passenger The passenger to calculate the total cost for.
     * @return The total cost of activities signed up by the passenger.
     */
    double getTotalCostForPassenger(Passenger passenger);
}
