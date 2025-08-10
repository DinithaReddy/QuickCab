package models;

public class Ride {
    private User passenger;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User passenger, Driver driver, double distance, double fare) {
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return passenger.getName() + " with driver " + driver.getName() + 
               " in " + driver.getCab().getCabType() + " (" + driver.getCab().getCabNumber() + 
               ") - Distance: " + distance + " km, Fare: ₹" + fare;
    }
}
