 feature/UC12-datapersistenceandsystemrecovery
import java.io.*;
import java.util.*;

 feature/UC10-bookingcancellationandinventoryrollback
import java.util.*;
 feature/UC11-concurrentbookingsimulation
import java.util.concurrent.*;
 dev

class IllegalCancellationException extends Exception {

    public IllegalCancellationException(String message) {
feature/UC9-errorhandlingandvalidation
class BookingValidationException extends Exception {
    public BookingValidationException(String message) {
 dev
        super(message);
    }
}
 dev

 feature/UC7-addonserviceselection
import java.util.ArrayList;
import java.util.List;
 dev

public class BookMyStayApp {
    private static final String DATA_FILE = "system_state.txt";
    private static int suiteInventory = 10;
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        loadSystemState();

        System.out.println("Current Inventory after startup: " + suiteInventory);
        if (suiteInventory > 0) {
            suiteInventory--;
            history.add("BK-" + System.currentTimeMillis() + " | Status: SUCCESS");
            System.out.println("New booking processed.");
        }
        saveSystemState();
        System.out.println("System state persisted. Safe to exit.");
    }

    private static void saveSystemState() {
        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_FILE))) {

            out.println(suiteInventory);

            for (String record : history) {
                out.println(record);
            }
        } catch (IOException e) {
            System.err.println("Failed to save state: " + e.getMessage());
        }
 feature/UC12-datapersistenceandsystemrecovery


 feature/UC11-concurrentbookingsimulation
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("--- All Requests Processed ---");
        System.out.println("Final Inventory: " + suiteInventory);
        System.out.println("Final History Size: " + history.size());
 dev
    }

    private static void loadSystemState() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("No previous state found. Starting fresh.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {

            if (scanner.hasNextLine()) {
                suiteInventory = Integer.parseInt(scanner.nextLine());
            }
            while (scanner.hasNextLine()) {
                history.add(scanner.nextLine());
            }
            System.out.println("Successfully restored " + history.size() + " records.");
        } catch (Exception e) {
            System.err.println("State file corrupted. Reverting to defaults.");
            suiteInventory = 10;
            history.clear();
        }

 feature/UC10-bookingcancellationandinventoryrollback
        System.out.println("Final Inventory: " + suiteInventory);
        System.out.println("Rooms ready for re-assignment: " + releasedRooms);

 feature/UC9-errorhandlingandvalidation
        // System remains stable and can process the next request
        System.out.println("System status: Running safely.");
 dev
    }

    public static void cancelBooking(String bookingId) throws IllegalCancellationException {
        if (!activeBookings.containsKey(bookingId)) {
            throw new IllegalCancellationException("Booking ID " + bookingId + " not found or already cancelled.");
        }

 feature/UC10-bookingcancellationandinventoryrollback
        String roomType = activeBookings.get(bookingId);

        if (roomType.equals("Suite")) {
            suiteInventory++;

            releasedRooms.push("ROOM-" + bookingId.split("-")[1]);
        }

        activeBookings.remove(bookingId);

        System.out.println("[SUCCESS] Cancellation processed for " + bookingId);

        // 2. Guard System State (Inventory Check)
        if (roomType.equals("Suite") && availableSuites <= 0) {
            throw new BookingValidationException("No inventory available for: " + roomType);

 feature/UC8-bookinghistoryandreporting
        System.out.println("======= FINAL BOOKING HISTORY REPORT =======");

        if (historyReport.isEmpty()) {
            System.out.println("No history found for today.");

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
 dev
        } else {
            for (String record : historyReport) {
                System.out.println("[RECORD] " + record);
            }
 dev
        }
feature/UC8-bookinghistoryandreporting

        System.out.println("============================================");
        System.out.println("Total Records Processed: " + historyReport.size());

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

 feature/UC9-errorhandlingandvalidation
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
 dev
dev
 dev
 dev
    }
}