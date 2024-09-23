package observer;

public class User implements Observer {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void update(String message) {
        // Adding color to the output
        System.out.println("\033[0;32m" + username + " received notification: " + message + "\033[0m");
    }
}
