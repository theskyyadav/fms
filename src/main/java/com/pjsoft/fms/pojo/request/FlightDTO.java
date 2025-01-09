package com.pjsoft.fms.pojo.request;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class FlightDTO {
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    @NotNull(message = "Flight number is required")
	    @Positive(message = "Flight number must be a positive value")
	    private BigInteger flightNo;

	    @Column(nullable = false)
	    @NotNull(message = "Carrier name is required")
	    @Size(min = 3, max = 50, message = "Carrier name must be between 3 and 50 characters")
	    private String carrierName;

	    @Column(nullable = false)
	    @NotNull(message = "Flight model is required")
	    @Size(min = 3, max = 50, message = "Flight model must be between 3 and 50 characters")
	    private String flightModel;

	    @Column(nullable = false)
	    @NotNull(message = "Seat capacity is required")
	    @Positive(message = "Seat capacity must be a positive value")
	    private int seatCapacity;

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public BigInteger getFlightNo() {
	        return flightNo;
	    }

	    public void setFlightNo(BigInteger flightNo) {
	        this.flightNo = flightNo;
	    }

	    public String getCarrierName() {
	        return carrierName;
	    }

	    public void setCarrierName(String carrierName) {
	        this.carrierName = carrierName;
	    }

	    public String getFlightModel() {
	        return flightModel;
	    }

	    public void setFlightModel(String flightModel) {
	        this.flightModel = flightModel;
	    }

	    public int getSeatCapacity() {
	        return seatCapacity;
	    }

	    public void setSeatCapacity(int seatCapacity) {
	        this.seatCapacity = seatCapacity;
	    }
	}
