public class OnlineMonitor implements QueueObserver {
    private final String monitorId;

    public OnlineMonitor(String monitorId) {
        this.monitorId = monitorId;
        QueueManager.getInstance().addObserver(this);
    }

    @Override
    public void update(int currentNumber) {
        System.out.println("Monitor " + monitorId + ": Current Queue Number is " + currentNumber);
    }

    public void stopMonitoring() {
        QueueManager.getInstance().removeObserver(this);
    }

    public String getMonitorId() {
        return monitorId;
    }
}