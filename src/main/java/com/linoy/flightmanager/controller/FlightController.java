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
                new Flight(1L, "Paris", 350),
                new Flight(2L, "London", 280),
                new Flight(3L, "Rome", 420)
        );
    }
}