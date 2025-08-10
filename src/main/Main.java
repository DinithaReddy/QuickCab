package main;

import java.util.*;
import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Create drivers with different cab types
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Tharun", new SUVCab("SVU-1234")));
        drivers.add(new Driver("Anu", new MiniCab("MINI-5678")));
        drivers.add(new Driver("Deekshi", new LuxuryCab("LUX-9999")));

        System.out.println("Welcome to Ride Booking System");

        // 2. Create a passenger
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        User passenger = new User(userName);

        boolean running = true;
        while (running) {
            // Show drivers
            System.out.println("\nAvailable Drivers:");
            for (int i = 0; i < drivers.size(); i++) {
                Driver d = drivers.get(i);
                System.out.printf("%d. %s - %s (%s) ₹%.2f/km\n",
                        i + 1,
                        d.getName(),
                        d.getCab().getCabType(),
                        d.getCab().getCabNumber(),
                        d.getCab().getRatePerKm());
            }

            // Choose driver
            System.out.print("Choose driver (number): ");
            int driverChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (driverChoice < 1 || driverChoice > drivers.size()) {
                System.out.println("Invalid driver selection");
                continue;
            }
            Driver chosenDriver = drivers.get(driverChoice - 1);

            // Distance input
            System.out.print("Enter distance (in km): ");
            double distance = sc.nextDouble();
            sc.nextLine();

            // Calculate fare
            double fare = chosenDriver.getCab().getRatePerKm() * distance;
            Ride ride = new Ride(passenger, chosenDriver, distance, fare);

            System.out.println("\nRide Details:");
            System.out.println(ride);

            // Payment method
            System.out.println("\nSelect Payment Method:");
            System.out.println("1. Card");
            System.out.println("2. UPI");
            System.out.print("Enter choice: ");
            int payChoice = sc.nextInt();
            sc.nextLine();

            PaymentService payment;
            if (payChoice == 1) {
                payment = new CardPayment();
            } else if (payChoice == 2) {
                payment = new UpiPayment();
            } else {
                System.out.println("Invalid payment choice");
                continue;
            }

            payment.processPayment(fare);

            // Continue?
            System.out.print("\nDo you want to book another ride? (yes/no): ");
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                running = false;
            }
        }

        System.out.println("\nThank you for using our Cab Service!");
        sc.close();
    }
}
