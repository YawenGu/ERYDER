import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AdminPanel {
    private final ArrayList<RegisteredUsers> registeredUsersList;
    private final Scanner sc;

    public AdminPanel() {
        registeredUsersList = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void userManagementOptions() {
        while (true) {
            System.out.println("\n===== User Management Panel =====");
            System.out.println("1. Add Registered User");
            System.out.println("2. View All Registered Users");
            System.out.println("3. Remove Registered User");
            System.out.println("4. Update Registered User");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> addRegisteredUsers();
                case 2 -> viewRegisteredUsers();
                case 3 -> removeRegisteredUsers();
                case 4 -> updateRegisteredUsers();
                case 0 -> {
                    System.out.println("Exit.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void addRegisteredUsers() {
        System.out.print("How many users to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- User " + (i + 1) + " ---");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Date of Birth (yyyy-MM-dd): ");
            String dob = sc.nextLine();

            System.out.print("Card Number: ");
            String cardNo = sc.nextLine();

            System.out.print("Card Provider: ");
            String provider = sc.nextLine();

            System.out.print("Card Expiry (MM/yy): ");
            String expiry = sc.nextLine();

            System.out.print("CVV: ");
            String cvv = sc.nextLine();

            System.out.print("User Type (Regular/VIP): ");
            String type = sc.nextLine();

            String[] trips = new String[3];
            for (int t = 0; t < 3; t++) {
                System.out.println("\nTrip " + (t + 1));
                System.out.print("Date (yyyy-MM-dd): ");
                String date = sc.nextLine();
                System.out.print("Source: ");
                String src = sc.nextLine();
                System.out.print("Destination: ");
                String dest = sc.nextLine();
                System.out.print("Fare: ");
                double fare = sc.nextDouble();
                sc.nextLine();
                System.out.print("Feedback: ");
                String feed = sc.nextLine();

                String trip = "Date: " + date +
                        ", Source: " + src +
                        ", Destination: " + dest +
                        ", Fare: " + fare +
                        ", Feedback: " + feed;
                trips[t] = trip;
            }

            RegisteredUsers user = new RegisteredUsers(
                    name, email, dob, cardNo, provider, expiry, cvv, type, trips
            );
            registeredUsersList.add(user);
            System.out.println("User added.");
        }
    }

    public void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }

        for (RegisteredUsers u : registeredUsersList) {
            System.out.println("\n------------------------");
            System.out.println("Name: " + u.getName());
            System.out.println("Email: " + u.getEmailAddress());
            System.out.println("DOB: " + u.getDateOfBirth());
            System.out.println("Card: " + u.getCardNumber());
            System.out.println("Provider: " + u.getCardProvider());
            System.out.println("Expiry: " + u.getCardExpiryDate());
            System.out.println("CVV: " + u.getCvv());
            System.out.println("Type: " + u.getUserType());

            System.out.println("Last 3 Trips:");
            String[] trips = u.getLastThreeTrips();
            for (String trip : trips) {
                System.out.println("- " + trip);
            }
        }
    }

    public void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter email to remove: ");
        String email = sc.nextLine();

        Iterator<RegisteredUsers> it = registeredUsersList.iterator();
        boolean found = false;

        while (it.hasNext()) {
            RegisteredUsers u = it.next();
            if (u.getEmailAddress().equals(email)) {
                it.remove();
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("User removed.");
        else
            System.out.println("No user found with this email.");
    }

    public void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to update");
            return;
        }

        System.out.print("Enter email to update: ");
        String email = sc.nextLine();

        boolean found = false;
        for (RegisteredUsers u : registeredUsersList) {
            if (u.getEmailAddress().equals(email)) {
                found = true;

                System.out.println("\n--- Update User (Press Enter to keep old value) ---");

                System.out.print("Name [" + u.getName() + "]: ");
                String name = sc.nextLine();
                if (!name.isBlank()) u.setName(name);

                System.out.print("DOB [" + u.getDateOfBirth() + "]: ");
                String dob = sc.nextLine();
                if (!dob.isBlank()) u.setDateOfBirth(dob);

                System.out.print("Card Number [" + u.getCardNumber() + "]: ");
                String card = sc.nextLine();
                if (!card.isBlank()) u.setCardNumber(card);

                System.out.print("Provider [" + u.getCardProvider() + "]: ");
                String pro = sc.nextLine();
                if (!pro.isBlank()) u.setCardProvider(pro);

                System.out.print("Expiry [" + u.getCardExpiryDate() + "]: ");
                String exp = sc.nextLine();
                if (!exp.isBlank()) u.setCardExpiryDate(exp);

                System.out.print("CVV [" + u.getCvv() + "]: ");
                String cvv = sc.nextLine();
                if (!cvv.isBlank()) u.setCvv(cvv);

                System.out.print("Type [" + u.getUserType() + "]: ");
                String type = sc.nextLine();
                if (!type.isBlank()) u.setUserType(type);

                System.out.println("User updated.");
                break;
            }
        }

        if (!found) {
            System.out.println("No user found with this email.");
        }
    }
}