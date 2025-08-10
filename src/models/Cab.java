package models;

public class Cab {
    protected String cabType;
    protected String cabNumber;
    protected double ratePerKm;

    public Cab(String cabType, String cabNumber, double ratePerKm) {
        this.cabType = cabType;
        this.cabNumber = cabNumber;
        this.ratePerKm = ratePerKm;
    }

    public String getCabType() {
        return cabType;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}
