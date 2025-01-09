package com.pjsoft.fms.repository;

import com.pjsoft.fms.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
