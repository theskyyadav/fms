package com.pjsoft.fms.pojo.response;

import java.time.LocalDateTime;

import com.pjsoft.fms.model.Airport;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class ScheduleResponseDTO {

	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    @NotNull(message = "Departure time is required")
	    @FutureOrPresent(message = "Departure time cannot be in the past")
	    private LocalDateTime departureTime;

	    @Column(nullable = false)
	    @NotNull(message = "Arrival time is required")
	    @PastOrPresent(message = "Arrival time cannot be in the future")
	    private LocalDateTime arrivalTime;

	public
	Airport getDepartureAirport() {

		return departureAirport;
	}

	public
	void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public
	Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public
	void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	@ManyToOne

	@JoinColumn(name = "departure_airport_id", nullable = false)

	private Airport departureAirport;

	@ManyToOne

	@JoinColumn(name = "arrival_airport_id", nullable = false)

	private Airport arrivalAirport;
	    
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(LocalDateTime departureTime) {
			this.departureTime = departureTime;
		}

		public LocalDateTime getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(LocalDateTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}

		

	}