package factory;

public class MageFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        String characterClass = "Mage";
        String[] skills = {"Fireball", "Ice Spike"};
        Character character = new Character(name, characterClass, skills);
        return character;
    }
}
