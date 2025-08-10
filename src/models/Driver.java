package models;

public class Driver {
    private String name;
    private Cab cab;

    public Driver(String name, Cab cab) {
        this.name = name;
        this.cab = cab;
    }

    public String getName() {
        return name;
    }

    public Cab getCab() {
        return cab;
    }
}
