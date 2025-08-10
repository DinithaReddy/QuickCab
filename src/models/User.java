package models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Ride> rideHistory;

    public User(String name) {
        this.name = name;
        this.rideHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRide(Ride ride) {
        rideHistory.add(ride);
    }

    public void showRideHistory() {
        System.out.println("\nRide History for " + name + ":");
        if (rideHistory.isEmpty()) {
            System.out.println("No rides taken yet.");
        } else {
            for (Ride r : rideHistory) {
                System.out.println(r);
            }
        }
    }
}
