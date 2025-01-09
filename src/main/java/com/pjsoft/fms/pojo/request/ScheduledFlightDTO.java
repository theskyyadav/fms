package com.pjsoft.fms.pojo.request;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.model.Schedule;
import jakarta.persistence.*;

public class ScheduledFlightDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int  availableSeats;

	public
	Schedule getSchedule() {
		return schedule;
	}

	public
	void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public
	Flight getFlight() {
		return flight;
	}

	public
	void setFlight(Flight flight) {
		this.flight = flight;
	}

	// ScheduledFlight
	@ManyToOne
	@JoinColumn(name = "flight_id", nullable = false)
	private Flight flight;


	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

}