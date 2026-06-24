package com.linoy.flightmanager.model;

public class Flight {

    private Long id;
    private String destination;
    private double price;

    public Flight(Long id, String destination, double price) {
        this.id = id;
        this.destination = destination;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }
}