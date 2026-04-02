import java.util.*;
import java.util.concurrent.*;

public class BookMyStayApp {
    private static int suiteInventory = 2;
    private static final Object lock = new Object();
    private static List<String> history = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        String[] guests = {"Alwyn", "John", "Alice", "Bob", "Charlie"};

        System.out.println("Initial Inventory: " + suiteInventory);
        System.out.println("--- Starting Concurrent Bookings ---");

        for (String guest : guests) {
            executor.execute(() -> bookRoom(guest));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("--- All Requests Processed ---");
        System.out.println("Final Inventory: " + suiteInventory);
        System.out.println("Final History Size: " + history.size());
    }

    public static void bookRoom(String guest) {
        synchronized (lock) {
            if (suiteInventory > 0) {
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                suiteInventory--;
                history.add("Guest: " + guest + " | Status: SUCCESS");
                System.out.println("[CONFIRMED] Room allocated to: " + guest);
            } else {
                System.out.println("[FAILED] No rooms left for: " + guest);
            }
        }
    }
}