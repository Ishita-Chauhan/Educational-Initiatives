package factory;

public class WarriorFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        String characterClass = "Warrior";
        String[] skills = {"Shield Bash", "Sword Slash"};
        Character character = new Character(name, characterClass, skills);
        return character;
    }
}

