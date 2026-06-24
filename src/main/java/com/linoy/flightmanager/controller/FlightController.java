package com.linoy.flightmanager.controller;

import com.linoy.flightmanager.model.Flight;
import com.linoy.flightmanager.repository.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5174")
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
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return flightRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight updatedFlight) {
        return flightRepository.findById(id)
                .map(flight -> {
                    flight.setFlightCode(updatedFlight.getFlightCode());
                    flight.setCancelled(updatedFlight.isCancelled());
                    flight.setPrice(updatedFlight.getPrice());
                    flight.setDepartureTime(updatedFlight.getDepartureTime());
                    flight.setLandingTime(updatedFlight.getLandingTime());
                    flight.setDestination(updatedFlight.getDestination());

                    Flight savedFlight = flightRepository.save(flight);
                    return ResponseEntity.ok(savedFlight);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Flight> cancelFlight(@PathVariable Long id) {
        return flightRepository.findById(id)
                .map(flight -> {
                    flight.cancelFlight();
                    Flight savedFlight = flightRepository.save(flight);
                    return ResponseEntity.ok(savedFlight);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        if (!flightRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        flightRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Flight> searchFlightsByDestination(@RequestParam String destination) {
    return flightRepository.findByDestinationIgnoreCase(destination);
    }
}