 UC9
// Custom Exception for Fail-Fast handling
class BookingValidationException extends Exception {
    public BookingValidationException(String message) {
        super(message);
    }
}

 UC7
import java.util.ArrayList;
import java.util.List;
 dev

UC8
public class BookMyStayApp {
UC9
    private static int availableSuites = 1; // Example inventory state


public class UseCase7AddOnServiceSelection {

 UC6
import java.util.*;

 UC5
import java.util.HashSet;
import java.util.LinkedList;
 dev

 UC3
import java.util.HashMap;
 dev

public class BookMyStayApp {
dev
 dev
 dev
    public static void main(String[] args) {
        try {
            // Simulated Guest Input
            processBooking("Alice", "Penthouse"); // This should trigger a validation error
        } catch (BookingValidationException e) {
            // Graceful Failure Handling: Display meaningful message without crashing
            System.err.println("[VALIDATION ERROR] " + e.getMessage());
        }

        // System remains stable and can process the next request
        System.out.println("System status: Running safely.");
    }

    public static void processBooking(String customer, String roomType) throws BookingValidationException {
        // 1. Validate Room Type (Input Validation)
        if (!roomType.equals("Suite") && !roomType.equals("Double") && !roomType.equals("Single")) {
            throw new BookingValidationException("Invalid room type: " + roomType);
        }

        // 2. Guard System State (Inventory Check)
        if (roomType.equals("Suite") && availableSuites <= 0) {
            throw new BookingValidationException("No inventory available for: " + roomType);
        }
 UC8

 UC9
        // 3. Update State (Only reached if validation passes)
        if (roomType.equals("Suite")) availableSuites--;
        System.out.println("Booking successful for " + customer);

        System.out.println("============================================");
        System.out.println("Total Records Processed: " + historyReport.size());

 UC7
        System.out.println("\nTotal services added: " + selectedServices.size());


 UC6
        System.out.println("\nTotal Rooms Allocated Today: " + allocatedRooms.size());

 UC5
        System.out.println("\nTotal Rooms Allocated Today: " + var2.size());

        if (!found) {
            System.out.println("Sorry, no rooms available at the moment.");
        }

      
abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails(int availability) {
        System.out.println(getClass().getSimpleName() + " Details:");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq.ft");
        System.out.println("Price per Night: ₹" + pricePerNight);
        System.out.println("Available Rooms: " + availability);
        System.out.println("-----------------------------");
    }
}

class SingleRoom extends Room {
    public SingleRoom(int beds, int size, double price) {
        super(beds, size, price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom(int beds, int size, double price) {
        super(beds, size, price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(int beds, int size, double price) {
        super(beds, size, price);
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System v2.1.000");

        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        Room single = new SingleRoom(1, 200, 1000.0);
        Room doubleR = new DoubleRoom(2, 350, 1800.0);
        Room suite = new SuiteRoom(3, 600, 3500.0);

        single.displayRoomDetails(singleRoomAvailability);
        doubleR.displayRoomDetails(doubleRoomAvailability);
        suite.displayRoomDetails(suiteRoomAvailability);

        System.out.println("Application terminated."); dev
dev
 dev
 dev
dev
 dev
    }
}