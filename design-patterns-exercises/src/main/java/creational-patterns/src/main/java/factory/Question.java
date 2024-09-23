package factory;


public class Question {
    private String question;
    private String[] options;
    private String answer;

    public Question(String question, String[] options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(answer);
    }
}
