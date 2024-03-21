# Travel Agency Management System

This project is a Java-based implementation of a Travel Agency Management System. It allows travel agencies to maintain their travel packages' itineraries and manage passengers' activities and sign-ups.

## Overview

The system consists of several key components:

1. **Models**:
   - `Activity`: Represents an activity available at a destination.
   - `Destination`: Represents a travel destination with a list of activities.
   - `Passenger`: Abstract class representing a passenger with subclasses like `StandardPassenger`, `GoldPassenger`, and `PremiumPassenger`.
   - `TravelPackage`: Represents a travel package with an itinerary, passenger capacity, and list of passengers.

2. **Services**:
   - `TravelService`: Interface defining operations like printing itineraries, managing passenger activities, and signing up for activities.
   - `TravelServiceImpl`: Implementation of `TravelService` with various functionalities.

3. **Main Application**:
   - `Main`: Main class containing the application entry point and user interface for interacting with the system.

4. **Tests**:
   - Unit tests are provided for models and services to ensure functionality and code quality.
  

## File Structures:
TravelPackage/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── models/
│   │       │   ├── Activity.java
│   │       │   ├── Destination.java
│   │       │   ├── Passenger.java
│   │       │   └── TravelPackage.java
│   │       │
│   │       ├── services/
│   │       │   ├── TravelService.java
│   │       │   └── TravelServiceImpl.java
│   │       │
│   │       └── Main.java
│   │
│   └── test/
│       └── java/
│           ├── services/
│           │   └── TravelServiceTest.java
│           │
│           └── models/
│               ├── ActivityTest.java
│               ├── DestinationTest.java
│               ├── PassengerTest.java
│               └── TravelPackageTest.java
│
└── pom.xml (for Maven dependencies)


## Technologies Used

- Java programming language
- Maven for dependency management
- JUnit for unit testing

## How to Use

1. Clone the repository to your local machine.
2. Open the project in an IDE (like IntelliJ IDEA or Eclipse).
3. Navigate to `Main.java` and run the application.
4. Follow the on-screen instructions to interact with the Travel Agency Management System.

## Assumptions and Dummy Values

- Assumptions:
  - Each passenger has a unique passenger number.
  - Activities have a cost, and capacity, and are associated with a specific destination.
  - Passengers can sign up for activities based on their passenger type (Standard, Gold, Premium).

- Dummy Values (used in Main.java for testing purposes):
  - Dummy passenger names and balances are used for creating sample passengers.
  - Sample travel destinations and activities are created for testing itineraries and sign-up functionalities.
