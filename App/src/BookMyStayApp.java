import java.util.HashSet;
import java.util.LinkedList;

public class BookMyStayApp {
    public static void main(String[] var0) {
        LinkedList var1 = new LinkedList();
        var1.add("Customer_Alwyn");
        var1.add("Customer_John");
        HashSet var2 = new HashSet();
        System.out.println("--- Processing Room Allocations ---");

        while(!var1.isEmpty()) {
            String var3 = (String)var1.poll();
            int var10000 = 100 + var2.size();
            String var4 = "ROOM-" + (var10000 + 1);
            if (var2.add(var4)) {
                System.out.println("SUCCESS: " + var3 + " assigned to " + var4);
            } else {
                System.out.println("ERROR: Room " + var4 + " is already occupied!");
            }
        }

        System.out.println("\nTotal Rooms Allocated Today: " + var2.size());
    }
}