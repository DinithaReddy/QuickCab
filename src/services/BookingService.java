package services;

import models.*;

import java.util.List;
import java.util.Random;

public class BookingService {
    private static final double BASE_FARE = 50;
    private static final double RATE_PER_KM = 15;

    public Ride bookRide(User passenger, List<Driver> drivers) {
        Random rand = new Random();

        Driver driver = drivers.get(rand.nextInt(drivers.size()));
        double distance = 2 + rand.nextInt(60); // 2–60 km
        double fare = BASE_FARE + (RATE_PER_KM * distance);

        Ride ride = new Ride(passenger, driver, distance, fare);
        passenger.addRide(ride);
        return ride;
    }
}
