package factory;

public class ArcherFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        String characterClass = "Archer";
        String[] skills = {"Arrow Shot", "Stealth"};
        Character character = new Character(name, characterClass, skills);
        return character;
    }
}
