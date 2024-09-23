package factory;


public class Dialogue {
    private String text;

    public Dialogue(String text) {
        this.text = text;
    }

    public void display() {
        System.out.println(text);
    }
}
