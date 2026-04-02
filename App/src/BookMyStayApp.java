 UC3
import java.util.HashMap;

public class BookMyStayApp {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);

        System.out.println("--- Searching for Available Rooms ---");
        boolean found = false;
        for (String type : inventory.keySet()) {
            int count = inventory.get(type);

            if (count > 0) {
                System.out.println("Found: " + type + " (" + count + " left)");
                found = true;
            }
        }

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
    }
}