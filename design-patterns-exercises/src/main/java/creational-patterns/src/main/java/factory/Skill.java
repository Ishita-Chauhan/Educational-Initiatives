package factory;

public class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
