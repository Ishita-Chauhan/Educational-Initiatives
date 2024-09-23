package command;

import java.util.Stack;

public class TextEditor {
    private StringBuilder text = new StringBuilder();
    private Stack<Command> history = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();  // To store undone commands for redo
    private int actionCount = 0;
    private int undoCount = 0;

    // Display a random inspirational quote at startup
    public void displayRandomQuote() {
        String[] quotes = {
                "Keep typing, you're doing great! 🚀",
                "A journey of a thousand lines of code begins with a single keystroke.",
                "You got this, coder! 💻",
                "Debugging is like being the detective in a crime drama where you are also the murderer."
        };
        int randomIndex = (int) (Math.random() * quotes.length);
        System.out.println("\u001B[34m💡 Daily Inspiration: " + quotes[randomIndex] + "\u001B[0m");
    }

    // Add text with typewriter effect and theme
    public void addText(String newText, boolean typewriterEffect) {
        Command command = new AddTextCommand(this, newText, typewriterEffect);
        command.execute();
        history.push(command);
        redoStack.clear();  // Clear redo stack on new command
        actionCount++;
        checkAchievements();  // Check for achievements after every action
    }

    // Undo functionality
    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
            redoStack.push(lastCommand);  // Store the undone command for redo
            undoCount++;
            checkAchievements();  // Check for undo achievements
        } else {
            System.out.println("\u001B[31mNo actions to undo!\u001B[0m");
        }
    }

    // Redo functionality
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command lastUndoneCommand = redoStack.pop();
            lastUndoneCommand.execute();
            history.push(lastUndoneCommand);
            System.out.println("\u001B[33mRedo successful! Current text: " + getText() + "\u001B[0m");
        } else {
            System.out.println("\u001B[31mNo actions to redo!\u001B[0m");
        }
    }

    // View history of commands
    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("\u001B[31mNo commands in history!\u001B[0m");
        } else {
            System.out.println("\u001B[32mCommand History:\u001B[0m");
            for (Command command : history) {
                System.out.println(command);
            }
        }
    }

    // Switch between different themes
    public void switchTheme(String theme) {
        switch (theme.toLowerCase()) {
            case "dark":
                System.out.println("\u001B[30;47mDark Mode Activated! Type like a hacker!\u001B[0m");
                break;
            case "zen":
                System.out.println("\u001B[32mZen Mode Activated! Type with peace and calm...\u001B[0m");
                break;
            case "retro":
                System.out.println("\u001B[33mRetro Mode Activated! You hear the clickety-clack of an old typewriter.\u001B[0m");
                break;
            default:
                System.out.println("\u001B[37mStandard Mode Activated!\u001B[0m");
                break;
        }
    }

    // Append text to the current document
    public void appendText(String newText, boolean typewriterEffect) {
        if (typewriterEffect) {
            typeWriterEffect(newText);
        } else {
            text.append(newText);
            System.out.println("\u001B[36mCurrent Text: " + text + "\u001B[0m");
        }
    }

    // Remove text from the document
    public void removeText(String newText) {
        int currentLength = text.length();
        int removeLength = newText.length();

        // Ensure that we don't try to delete more characters than exist
        if (currentLength >= removeLength) {
            text.delete(currentLength - removeLength, currentLength);
        } else {
            System.out.println("\u001B[31mError: Not enough characters to remove!\u001B[0m");
        }
    }

    // Simulate a typewriter effect
    private void typeWriterEffect(String newText) {
        for (char c : newText.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(150);  // Simulate delay for typewriter effect
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();  // Move to next line after typing
    }

    // Get the current text in the editor
    public String getText() {
        return text.toString();
    }

    // Check and display achievements
    private void checkAchievements() {
        if (actionCount == 10) {
            System.out.println("\u001B[33m🏆 Achievement Unlocked: Typing Master! You've made 10 commands! 🎉\u001B[0m");
        }

        if (undoCount == 5) {
            System.out.println("\u001B[33m🏆 Achievement Unlocked: Undo Wizard! You've undone 5 actions! 🧙‍♂️\u001B[0m");
        }
    }
}
