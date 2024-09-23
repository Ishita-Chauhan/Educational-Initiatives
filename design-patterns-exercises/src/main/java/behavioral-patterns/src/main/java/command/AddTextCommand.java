package command;

public class AddTextCommand implements Command {
    private TextEditor editor;
    private String newText;
    private boolean typewriterEffect;

    public AddTextCommand(TextEditor editor, String newText, boolean typewriterEffect) {
        this.editor = editor;
        this.newText = newText;
        this.typewriterEffect = typewriterEffect;
    }

    @Override
    public void execute() {
        editor.appendText(newText, typewriterEffect);
        System.out.println("\u001B[32mText after adding: " + editor.getText() + "\u001B[0m");
    }

    @Override
    public void undo() {
        editor.removeText(newText);
        System.out.println("\u001B[31mText after undo: " + editor.getText() + "\u001B[0m");
    }

    @Override
    public String toString() {
        return "AddTextCommand: " + newText;
    }
}
