package observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        Scanner scanner = new Scanner(System.in);
        Map<String, User> userMap = new HashMap<>();

        while (true) {
            System.out.println("\n1. Subscribe User\n2. Unsubscribe User\n3. Add Notification\n4. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1": // Subscribe a user
                    System.out.print("Enter the username to subscribe: ");
                    String usernameToSubscribe = scanner.nextLine();
                    if (!userMap.containsKey(usernameToSubscribe)) {
                        User user = new User(usernameToSubscribe);
                        service.subscribe(user);
                        userMap.put(usernameToSubscribe, user);
                    } else {
                        System.out.println("⚠️ User " + usernameToSubscribe + " is already subscribed.");
                    }
                    break;

                case "2": // Unsubscribe a user
                    System.out.print("Enter the username to unsubscribe: ");
                    String usernameToUnsubscribe = scanner.nextLine();
                    User userToUnsubscribe = userMap.get(usernameToUnsubscribe);
                    if (userToUnsubscribe != null) {
                        service.unsubscribe(userToUnsubscribe);
                        userMap.remove(usernameToUnsubscribe);
                    } else {
                        System.out.println("⚠️ User " + usernameToUnsubscribe + " not found.");
                    }
                    break;

                case "3": // Add a notification
                    System.out.print("Enter the notification message: ");
                    String message = scanner.nextLine();
                    service.addNotification(message);
                    break;

                case "4": // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
