 feature/UC7-addonserviceselection
import java.util.ArrayList;
import java.util.List;

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {

 feature/UC5-bookingrequest
import java.util.HashSet;
import java.util.LinkedList;

 feature/UC3-roominventorymanagement
import java.util.HashMap;
 dev

 UC11
import java.util.*;
import java.util.concurrent.*;
 dev

 UC10
mport java.util.*;
class IllegalCancellationException extends Exception {
    public IllegalCancellationException(String message) {

 UC9
// Custom Exception for Fail-Fast handling
class BookingValidationException extends Exception {
    public BookingValidationException(String message) {
dev
        super(message);
    }
}
 dev

 UC7
import java.util.ArrayList;
import java.util.List;
 dev

UC8
public class BookMyStayApp {
 feature/UC5-bookingrequest
    public static void main(String[] var0) {
        LinkedList var1 = new LinkedList();
        var1.add("Customer_Alwyn");
        var1.add("Customer_John");
        HashSet var2 = new HashSet();
        System.out.println("--- Processing Room Allocations ---");
 dev

        List<String> selectedServices = new ArrayList<>();
        selectedServices.add("High-Speed WiFi");
        selectedServices.add("Buffet Breakfast");
        selectedServices.add("Late Check-out");
        System.out.println("--- Selected Add-on Services ---");
        if (selectedServices.isEmpty()) {
            System.out.println("No extra services selected.");
        } else {
            for (int i = 0; i < selectedServices.size(); i++) {
                System.out.println((i + 1) + ". " + selectedServices.get(i));
            }
        }
 feature/UC7-addonserviceselection
        System.out.println("\nTotal services added: " + selectedServices.size());

        System.out.println("\nTotal Rooms Allocated Today: " + var2.size());

 feature/UC3-roominventorymanagement
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
 feature/UC4-roomserviceandavailabilitycheck


 UC11
    private static int suiteInventory = 2;
    private static final Object lock = new Object();
    private static List<String> history = Collections.synchronizedList(new ArrayList<>());
dev

 dev
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);

 feature/UC4-roomserviceandavailabilitycheck
        System.out.println("--- Searching for Available Rooms ---");
        boolean found = false;
        for (String type : inventory.keySet()) {
            int count = inventory.get(type);

            if (count > 0) {
                System.out.println("Found: " + type + " (" + count + " left)");
                found = true;
            }
        }

 feature/UC3-roominventorymanagement
        System.out.println("--- Hotel Room Inventory ---");
 UC10

    private static int suiteInventory = 5;
    private static Stack<String> releasedRooms = new Stack<>();
    private static Map<String, String> activeBookings = new HashMap<>(); // ID -> RoomType

UC9
    private static int availableSuites = 1; // Example inventory state
 dev


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
 dev

        ExecutorService executor = Executors.newFixedThreadPool(5);
        String[] guests = {"Alwyn", "John", "Alice", "Bob", "Charlie"};
 dev
 dev

        if (!found) {
            System.out.println("Sorry, no rooms available at the moment.");
        }
 UC11

 UC8

 UC10
        activeBookings.remove(bookingId);

        System.out.println("[SUCCESS] Cancellation processed for " + bookingId);

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
dev
 dev
 dev
 dev
    }
}