 UC7
import java.util.ArrayList;
import java.util.List;

UC8
public class BookMyStayApp {

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
    public static void main(String[] args) {
        List<String> historyReport = new ArrayList<>();
        historyReport.add("ID: BK-001 | Customer: Alwyn | Room: Single | Status: PAID");
        historyReport.add("ID: BK-002 | Customer: John  | Room: Double | Status: PENDING");
        historyReport.add("ID: BK-003 | Customer: Alice | Room: Suite  | Status: PAID");

        System.out.println("======= FINAL BOOKING HISTORY REPORT =======");

        if (historyReport.isEmpty()) {
            System.out.println("No history found for today.");
        } else {
            for (String record : historyReport) {
                System.out.println("[RECORD] " + record);
            }
        }
 UC8

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
    }
}