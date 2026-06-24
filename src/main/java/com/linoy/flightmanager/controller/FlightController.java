package com.linoy.flightmanager.controller;

import com.linoy.flightmanager.model.Flight;
import com.linoy.flightmanager.repository.FlightRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
    }

    @PatchMapping("/{id}/cancel")
    public Flight cancelFlight(@PathVariable Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow();
        flight.cancelFlight();
        return flightRepository.save(flight);
    }
}