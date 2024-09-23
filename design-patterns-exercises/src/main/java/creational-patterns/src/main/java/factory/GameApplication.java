package factory;

import java.util.Scanner;

public class GameApplication {
    private Character character;
    private QuestManager questManager;

    public GameApplication() {
        questManager = new QuestManager();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game!");
        System.out.println("Choose your character class (Warrior, Mage, Archer):");
        String className = scanner.nextLine();

        CharacterFactory factory = null;
        switch (className.toLowerCase()) {
            case "warrior":
                factory = new WarriorFactory();
                break;
            case "mage":
                factory = new MageFactory();
                break;
            case "archer":
                factory = new ArcherFactory();
                break;
            default:
                System.out.println("Invalid class. Defaulting to Warrior.");
                factory = new WarriorFactory();
                break;
        }

        character = factory.createCharacter(className);

        // Start the first quest
        questManager.assignInitialQuest(character);
    }

    public static void main(String[] args) {
        GameApplication app = new GameApplication();
        app.start();
    }
}
