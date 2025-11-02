import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class QueueManager {
    private static QueueManager instance;
    private int currentQueueNumber;
    private final List<QueueObserver> observers;

    // Private constructor to prevent instantiation
    private QueueManager() {
        currentQueueNumber = 0;
        observers = new ArrayList<>();
    }

    // Static method to get the singleton instance
    public static synchronized QueueManager getInstance() {
        if (instance == null) {
            instance = new QueueManager();
        }
        return instance;
    }

    // Get the next queue number
    public synchronized int getNextNumber() {
        currentQueueNumber++;
        notifyObservers();
        return currentQueueNumber;
    }

    // Get current queue number without incrementing
    public int getCurrentNumber() {
        return currentQueueNumber;
    }

    // Reset the queue number
    public synchronized boolean resetQueueNumber(int newNumber) {
        if (newNumber >= 0) {
            currentQueueNumber = newNumber;
            notifyObservers();
            return true;
        }
        return false;
    }

    // Add an observer for real-time monitoring
    public void addObserver(QueueObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    // Remove an observer
    public void removeObserver(QueueObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers of queue number changes
    private void notifyObservers() {
        for (QueueObserver observer : observers) {
            observer.update(currentQueueNumber);
        }
    }
}