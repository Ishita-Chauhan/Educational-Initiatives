package factory;

import java.util.Scanner;

public class QuestManager {
    private int currentLevel = 1;
    private final String[] warriorTasks = {
            "What is a synonym of 'mysterious'? A) Obvious B) Cryptic C) Clear D) Simple",
            "What is 15 - 7? A) 8 B) 7 C) 6 D) 5",
            "What is the antonym of 'calm'? A) Peaceful B) Chaotic C) Quiet D) Relaxed"
    };

    private final String[] mageTasks = {
            "What is a synonym of 'clever' A) mystery B) smart C) non-rational D) stupid",
            "What is the square root of 16? A) 4 B) 2 C) 6 D) 8",
            "What is the antonym of 'light'? A) Here B) Bright C) Dim D) Dark"
    };

    private final String[] archerTasks = {
            "What is a synonym of 'bold' A) Fearful B) courageous C) sustain D) loyalty",
            "What is 10 + 5? A) 15 B) 13 C) 12 D) 20",
            "What is the antonym of 'fast'? A) Quick B) Slow C) Rapid D) Swift"
    };

    public void assignInitialQuest(Character character) {
        System.out.println(character.getStartingQuestMessage());
        Scanner scanner = new Scanner(System.in);

        while (currentLevel <= 3) {
            String[] tasks = getTasksForCharacter(character.getCharacterClass());
            String task = tasks[currentLevel - 1];
            System.out.println("Current Task: " + task);
            System.out.print("Enter your answer (A, B, C, D): ");
            String answer = scanner.nextLine();

            if (isCorrectAnswer(currentLevel, answer)) {
                System.out.println("Correct answer!");
                currentLevel++;
                if (currentLevel <= 3) {
                    System.out.println("You have advanced to level " + currentLevel + "!");
                }
            } else {
                System.out.println("Incorrect answer. Try again.");
            }
        }

        System.out.println("Quest completed: " + character.getStartingQuestMessage());
        System.out.println("Congratulations! You have completed the quest!");
    }

    private String[] getTasksForCharacter(String characterClass) {
        switch (characterClass.toLowerCase()) {
            case "warrior":
                return warriorTasks;
            case "mage":
                return mageTasks;
            case "archer":
                return archerTasks;
            default:
                return new String[]{};
        }
    }

    private boolean isCorrectAnswer(int level, String answer) {
        switch (level) {
            case 1:
                return "B".equalsIgnoreCase(answer);
            case 2:
                return "A".equalsIgnoreCase(answer);
            case 3:
                return "B".equalsIgnoreCase(answer);
            default:
                return false;
        }
    }
}
