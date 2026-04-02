import java.util.*;

public class BookMyStayApp {
    public static void main(String[] args) {

        Queue<String> requests = new LinkedList<>();
        requests.add("Customer_Alwyn");
        requests.add("Customer_John");

        Set<String> allocatedRooms = new HashSet<>();

        System.out.println("--- Processing Room Allocations ---");

        while (!requests.isEmpty()) {
            String customer = requests.poll();
            String roomId = "ROOM-" + (100 + allocatedRooms.size() + 1);
            if (allocatedRooms.add(roomId)) {
                System.out.println("SUCCESS: " + customer + " assigned to " + roomId);
            } else {
                System.out.println("ERROR: Room " + roomId + " is already occupied!");
            }
        }

        System.out.println("\nTotal Rooms Allocated Today: " + allocatedRooms.size());
    }
}
