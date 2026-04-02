mport java.util.*;
class IllegalCancellationException extends Exception {
    public IllegalCancellationException(String message) {
        super(message);
    }
}

public class BookMyStayApp {

    private static int suiteInventory = 5;
    private static Stack<String> releasedRooms = new Stack<>();
    private static Map<String, String> activeBookings = new HashMap<>(); // ID -> RoomType

    public static void main(String[] args) {

        activeBookings.put("BK-003", "Suite");
        suiteInventory = 4;

        System.out.println("Initial Inventory: " + suiteInventory);

        try {

            cancelBooking("BK-003");
            cancelBooking("BK-999");
        } catch (IllegalCancellationException e) {
            System.err.println("[CANCELLATION REJECTED] " + e.getMessage());
        }

        System.out.println("Final Inventory: " + suiteInventory);
        System.out.println("Rooms ready for re-assignment: " + releasedRooms);
    }

    public static void cancelBooking(String bookingId) throws IllegalCancellationException {
        if (!activeBookings.containsKey(bookingId)) {
            throw new IllegalCancellationException("Booking ID " + bookingId + " not found or already cancelled.");
        }

        String roomType = activeBookings.get(bookingId);

        if (roomType.equals("Suite")) {
            suiteInventory++;

            releasedRooms.push("ROOM-" + bookingId.split("-")[1]);
        }

        activeBookings.remove(bookingId);

        System.out.println("[SUCCESS] Cancellation processed for " + bookingId);
    }
}