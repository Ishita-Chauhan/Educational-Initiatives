package singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        command.ConfigurationManager configManager = command.ConfigurationManager.getInstance();
        ChangeLog changeLog = new ChangeLog();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Settings");
            System.out.println("2. Update Setting");
            System.out.println("3. View Change Log");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Assessment Type: " + configManager.getSetting("assessmentType"));
                    System.out.println("Content Mode: " + configManager.getSetting("contentMode"));
                    System.out.println("Difficulty Level: " + configManager.getSetting("difficultyLevel"));
                    System.out.println("Theme: " + configManager.getSetting("theme"));
                    break;
                case 2:
                    System.out.print("Enter setting key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String value = scanner.nextLine();
                    configManager.updateSetting(key, value);
                    changeLog.addEntry("Updated " + key + " to " + value);
                    break;
                case 3:
                    System.out.println("Change Log:");
                    for (String entry : changeLog.getEntries()) {
                        System.out.println("- " + entry);
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
