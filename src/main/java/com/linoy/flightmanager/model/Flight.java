package com.linoy.flightmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightCode;
    private boolean cancelled;
    private float price;
    private int departureTime;
    private int landingTime;
    private String destination;

    public Flight() {
    }

    public Flight(String flightCode, boolean cancelled, float price, int departureTime, int landingTime, String destination) {
        this.flightCode = flightCode;
        this.cancelled = cancelled;
        this.price = price;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public float getPrice() {
        return price;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getLandingTime() {
        return landingTime;
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightTime() {
        return landingTime - departureTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDepartureTime(int departureTime) {
        int delay = departureTime - this.departureTime;
        this.landingTime = this.landingTime + delay;
        this.departureTime = departureTime;
    }

    public void setLandingTime(int landingTime) {
        this.landingTime = landingTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void cancelFlight() {
        this.cancelled = true;
    }
}