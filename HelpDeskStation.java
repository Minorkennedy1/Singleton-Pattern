public class HelpDeskStation {
    private final int stationId;
    private final QueueManager queueManager;

    public HelpDeskStation(int stationId) {
        this.stationId = stationId;
        this.queueManager = QueueManager.getInstance();
    }

    // Serve the next customer and get their queue number
    public int serveNextCustomer() {
        return queueManager.getNextNumber();
    }

    // View the current queue number without incrementing
    public int viewCurrentNumber() {
        return queueManager.getCurrentNumber();
    }

    // Reset the queue to a specific number
    public boolean resetQueue(int newNumber) {
        return queueManager.resetQueueNumber(newNumber);
    }

    public int getStationId() {
        return stationId;
    }
}