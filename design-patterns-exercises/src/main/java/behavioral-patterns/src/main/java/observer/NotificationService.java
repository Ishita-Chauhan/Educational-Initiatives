package observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Observer> observers = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();

    // Subscribe a user
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("✨ " + ((User) observer).getUsername() + " has subscribed to notifications! ✨");
        System.out.println(getFunQuote());
    }

    // Unsubscribe a user
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println("⚠️ " + ((User) observer).getUsername() + " has unsubscribed from notifications! ⚠️");
        System.out.println(getFunQuote());
    }

    // Add a notification and notify all observers
    public void addNotification(String message) {
        notifications.add(message);
        System.out.println("\n🔔 New Notification: " + message);
        notifyAllObservers(message);
    }

    // Notify all observers
    private void notifyAllObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
            try {
                Thread.sleep(500); // Simulate delay for realism
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Fun quotes to display when a user subscribes/unsubscribes
    private String getFunQuote() {
        String[] quotes = {
                "🌟 Keep shining, you're doing great!",
                "🚀 Blast off! You've got notifications coming your way.",
                "✨ Stay curious, the best is yet to come!",
                "🎯 Stay focused, the world is full of opportunities!"
        };
        return quotes[(int) (Math.random() * quotes.length)];
    }
}
