package com.pjsoft.fms.repository;

import com.pjsoft.fms.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
