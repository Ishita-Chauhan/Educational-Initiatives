package factory;

public class Character {
    private String name;
    private String characterClass;
    private String[] skills;

    public Character(String name, String characterClass, String[] skills) {
        this.name = name;
        this.characterClass = characterClass;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public String[] getSkills() {
        return skills;
    }

    public String getStartingQuestMessage() {
        switch (characterClass.toLowerCase()) {
            case "warrior":
                return "Find the Lost Artifact: Search the nearby forest for the ancient artifact. You are looking for an oddly shaped tree with golden leaves.";
            case "mage":
                return "Find the Ancient Spell: Search the spell lab for the ancient scroll. You must find the hidden book of spells.";
            case "archer":
                return "Find the Golden Bow: Search the archery range for the legendary bow. You are searching for the target with a golden mark.";
            default:
                return "Find the Lost Artifact.";
        }
    }

    @Override
    public String toString() {
        return name + " the " + characterClass + " with skills: " + String.join(", ", skills);
    }
}
