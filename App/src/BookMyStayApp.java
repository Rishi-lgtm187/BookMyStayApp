import java.io.*;
import java.util.*;

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
    }
}