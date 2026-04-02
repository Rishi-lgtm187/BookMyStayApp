import java.util.ArrayList;
import java.util.List;

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {

        List<String> selectedServices = new ArrayList<>();
        selectedServices.add("High-Speed WiFi");
        selectedServices.add("Buffet Breakfast");
        selectedServices.add("Late Check-out");
        System.out.println("--- Selected Add-on Services ---");
        if (selectedServices.isEmpty()) {
            System.out.println("No extra services selected.");
        } else {
            for (int i = 0; i < selectedServices.size(); i++) {
                System.out.println((i + 1) + ". " + selectedServices.get(i));
            }
        }
        System.out.println("\nTotal services added: " + selectedServices.size());
    }
}