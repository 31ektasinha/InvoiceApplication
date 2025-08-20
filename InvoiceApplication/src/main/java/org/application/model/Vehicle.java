package org.application.model;

public class Vehicle {
    private String id;
    private String make;
    private String model;
    private double price;

    public Vehicle(String id, String make, String model, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
}

