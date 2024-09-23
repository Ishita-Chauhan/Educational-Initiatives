package command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.displayRandomQuote();  // Show an inspirational quote when starting

        Scanner scanner = new Scanner(System.in);
        boolean typewriterEffect = false;

        System.out.println("Choose a theme (dark, zen, retro): ");
        String theme = scanner.nextLine();
        editor.switchTheme(theme);

        // Typewriter effect option
        System.out.println("Would you like to enable Typewriter Effect? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            typewriterEffect = true;
        }

        // Text editor functionality
        while (true) {
            System.out.println("Enter text to add (or type 'undo', 'redo', 'history', 'exit' to quit): ");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "undo":
                    editor.undo();
                    break;
                case "redo":
                    editor.redo();
                    break;
                case "history":
                    editor.viewHistory();
                    break;
                case "exit":
                    System.out.println("Exiting text editor...");
                    scanner.close();
                    return;
                default:
                    editor.addText(input, typewriterEffect);
                    break;
            }
        }
    }
}
