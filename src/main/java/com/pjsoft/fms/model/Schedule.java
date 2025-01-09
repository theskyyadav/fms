package com.pjsoft.fms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.FutureOrPresent;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.PastOrPresent;


@Entity

public class Schedule {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private LocalDateTime departureTime;



    private LocalDateTime arrivalTime;

    @ManyToOne

    @JoinColumn(name = "departure_airport_id", nullable = false)

    private Airport departureAirport;

//    public
//    Schedule(LocalDateTime departureTime, LocalDateTime arrivalTime, Airport departureAirport, Airport arrivalAirport) {
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        this.departureAirport = departureAirport;
//        this.arrivalAirport = arrivalAirport;
//    }

    public Airport getDepartureAirport() {

        return departureAirport;

    }

    public void setDepartureAirport(Airport departureAirport) {

        this.departureAirport = departureAirport;

    }

    public Airport getArrivalAirport() {

        return arrivalAirport;

    }

    public void setArrivalAirport(Airport arrivalAirport) {

        this.arrivalAirport = arrivalAirport;

    }

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
