package com.pjsoft.fms.repository;

import com.pjsoft.fms.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
