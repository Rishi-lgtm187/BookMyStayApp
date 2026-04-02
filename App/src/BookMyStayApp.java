// Custom Exception for Fail-Fast handling
class BookingValidationException extends Exception {
    public BookingValidationException(String message) {
        super(message);
    }
}

public class BookMyStayApp {
    private static int availableSuites = 1; // Example inventory state

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

        // 3. Update State (Only reached if validation passes)
        if (roomType.equals("Suite")) availableSuites--;
        System.out.println("Booking successful for " + customer);
    }
}