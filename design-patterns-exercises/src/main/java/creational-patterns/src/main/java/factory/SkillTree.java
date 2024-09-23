package factory;


import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    private Map<String, String> skills;

    public SkillTree() {
        skills = new HashMap<>();
        skills.put("Warrior", "Shield Bash, Sword Slash");
        skills.put("Mage", "Fireball, Ice Spike");
        skills.put("Archer", "Arrow Shot, Stealth");
    }

    public void displaySkills() {
        System.out.println("Available skills for " + skills.toString());
    }
}
