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

    @PutMapping("/{id}")
public Flight updateFlight(@PathVariable Long id, @RequestBody Flight updatedFlight) {
    Flight flight = flightRepository.findById(id).orElseThrow();

    flight.setFlightCode(updatedFlight.getFlightCode());
    flight.setCancelled(updatedFlight.isCancelled());
    flight.setPrice(updatedFlight.getPrice());
    flight.setDepartureTime(updatedFlight.getDepartureTime());
    flight.setLandingTime(updatedFlight.getLandingTime());
    flight.setDestination(updatedFlight.getDestination());

    return flightRepository.save(flight);
}
}