package com.ioprogramming.jsondata.handsonpracticeproblems.convertlisttoarray;

public class Car {
    private String brand;
    private String model;
    private double price;
    private String speed;

    public Car(String brand, String model, double price, String speed) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getSpeed() {
        return speed;
    }
}