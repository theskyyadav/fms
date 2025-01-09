package com.pjsoft.fms.pojo.request;

import java.time.LocalDateTime;

import com.pjsoft.fms.model.Passenger;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingDTO {

	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    @NotNull(message = "Booking date is required")
//	    @PastOrPresent(message = "Booking date must be in the past or present")
	    private LocalDateTime bookingDate;

	@ManyToOne
	@JoinColumn(name = "passenger_id", nullable = false)
	private Passenger passenger;

	    @Column(nullable = false)
	    @NotBlank(message = "Booking status is required")
	    private String status;
		
		 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDateTime bookingDate) {
			this.bookingDate = bookingDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	public
	Passenger getPassenger() {
		return passenger;
	}

	public
	void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
}
