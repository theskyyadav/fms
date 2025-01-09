package com.pjsoft.fms.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
//    @NotNull(message = "Booking date is required")
//    @PastOrPresent(message = "Booking date must be in the past or present")
    private LocalDateTime bookingDate;

    @Column(nullable = false)
//    @NotBlank(message = "Booking status is required")
    private String status;
    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(ScheduledFlight scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }

    @ManyToOne
    @JoinColumn(name = "scheduled_flight_id", nullable = false)
    private ScheduledFlight scheduledFlight;
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


}