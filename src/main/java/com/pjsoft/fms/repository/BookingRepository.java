package com.pjsoft.fms.repository;

import com.pjsoft.fms.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface BookingRepository extends JpaRepository <Booking, Long> {
}
