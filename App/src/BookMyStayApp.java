import java.util.ArrayList;
import java.util.List;

public class BookMyStayApp {
    public static void main(String[] args) {
        List<String> historyReport = new ArrayList<>();
        historyReport.add("ID: BK-001 | Customer: Alwyn | Room: Single | Status: PAID");
        historyReport.add("ID: BK-002 | Customer: John  | Room: Double | Status: PENDING");
        historyReport.add("ID: BK-003 | Customer: Alice | Room: Suite  | Status: PAID");

        System.out.println("======= FINAL BOOKING HISTORY REPORT =======");

        if (historyReport.isEmpty()) {
            System.out.println("No history found for today.");
        } else {
            for (String record : historyReport) {
                System.out.println("[RECORD] " + record);
            }
        }

        System.out.println("============================================");
        System.out.println("Total Records Processed: " + historyReport.size());
    }
}