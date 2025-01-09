package com.pjsoft.fms.repository;

import com.pjsoft.fms.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface AirportRepository extends JpaRepository<Airport, Long> {
}
