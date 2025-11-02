public class Main {
    public static void main(String[] args) {
        // Create three help desk stations
        HelpDeskStation station1 = new HelpDeskStation(1);
        HelpDeskStation station2 = new HelpDeskStation(2);
        HelpDeskStation station3 = new HelpDeskStation(3);

        // Create online monitors
        OnlineMonitor webMonitor = new OnlineMonitor("WEB-1");
        OnlineMonitor mobileMonitor = new OnlineMonitor("MOBILE-1");

        System.out.println("Starting Pag-ibig Queue System...\n");

        // Simulate queue operations
        System.out.println("Station " + station1.getStationId() + " serving customer: " + station1.serveNextCustomer());
        System.out.println("Station " + station2.getStationId() + " serving customer: " + station2.serveNextCustomer());
        System.out.println("Station " + station3.getStationId() + " serving customer: " + station3.serveNextCustomer());

        // Reset queue from station 2
        System.out.println("\nResetting queue from Station " + station2.getStationId() + " to number 50");
        station2.resetQueue(50);

        // Continue serving after reset
        System.out.println("\nContinuing service after reset:");
        System.out.println("Station " + station1.getStationId() + " serving customer: " + station1.serveNextCustomer());
        
        // Stop mobile monitor
        System.out.println("\nStopping mobile monitor");
        mobileMonitor.stopMonitoring();

        // Serve one more customer
        System.out.println("\nFinal customer service:");
        System.out.println("Station " + station3.getStationId() + " serving customer: " + station3.serveNextCustomer());
    }
}