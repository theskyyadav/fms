package com.pjsoft.fms.repository;

import com.pjsoft.fms.model.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;

public
interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {
}
