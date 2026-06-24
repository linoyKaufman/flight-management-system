package com.linoy.flightmanager.repository;

import com.linoy.flightmanager.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
