package factory;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    private String name;
    private String description;
    private boolean isCompleted;
    private int currentLevel;
    private int totalLevels;
    private List<Question> questions;

    public Quest(String name, String description, int totalLevels, String characterClass) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
        this.currentLevel = 1;
        this.totalLevels = totalLevels;
        this.questions = new ArrayList<>();

        // Define questions based on character class
        if (characterClass.equalsIgnoreCase("Warrior")) {
            questions.add(new Question("What is a synonym of 'brave'?", new String[]{"A) Coward", "B) Fearless", "C) Timid", "D) Weak"}, "B"));
            questions.add(new Question("What is 12 + 8?", new String[]{"A) 18", "B) 20", "C) 21", "D) 22"}, "B"));
            questions.add(new Question("What is the antonym of 'victory'?", new String[]{"A) Defeat", "B) Triumph", "C) Success", "D) Win"}, "A"));
        } else if (characterClass.equalsIgnoreCase("Mage")) {
            questions.add(new Question("What is a synonym of 'mysterious'?", new String[]{"A) Obvious", "B) Cryptic", "C) Clear", "D) Simple"}, "B"));
            questions.add(new Question("What is 15 - 7?", new String[]{"A) 8", "B) 7", "C) 6", "D) 5"}, "A"));
            questions.add(new Question("What is the antonym of 'calm'?", new String[]{"A) Peaceful", "B) Chaotic", "C) Quiet", "D) Relaxed"}, "B"));
        } else if (characterClass.equalsIgnoreCase("Archer")) {
            questions.add(new Question("What is a synonym of 'swift'?", new String[]{"A) Slow", "B) Quick", "C) Lethargic", "D) Lazy"}, "B"));
            questions.add(new Question("What is 5 x 3?", new String[]{"A) 10", "B) 15", "C) 20", "D) 25"}, "B"));
            questions.add(new Question("What is the antonym of 'light'?", new String[]{"A) Bright", "B) Heavy", "C) Clear", "D) Soft"}, "B"));
        }
    }

    public boolean completeLevel(String response) {
        if (currentLevel <= totalLevels) {
            Question currentQuestion = questions.get(currentLevel - 1);
            if (currentQuestion.checkAnswer(response)) {
                System.out.println("Correct answer!");
                currentLevel++;
                if (currentLevel > totalLevels) {
                    isCompleted = true;
                    System.out.println("Quest completed: " + name);
                }
                return true;
            } else {
                System.out.println("Incorrect answer! Try again.");
                return false;
            }
        }
        return false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getCurrentQuestion() {
        return questions.get(currentLevel - 1).getQuestion();
    }

    public String[] getCurrentOptions() {
        return questions.get(currentLevel - 1).getOptions();
    }

    @Override
    public String toString() {
        return name + ": " + description + " (Level " + currentLevel + "/" + totalLevels + ")";
    }
}
