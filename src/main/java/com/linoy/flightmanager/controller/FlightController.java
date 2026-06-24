package com.linoy.flightmanager.controller;

import com.linoy.flightmanager.model.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    @GetMapping("/api/flights")
    public List<Flight> getFlights() {
        return List.of(
                new Flight("LY001", false, 350, 900, 1200, "Paris"),
                new Flight("BA202", false, 280, 1030, 1430, "London"),
                new Flight("AZ303", false, 420, 700, 1030, "Rome")
        );
    }
}