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
    }
}