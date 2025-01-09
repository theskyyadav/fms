package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.service.FlightService;
import com.pjsoft.fms.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public
    List<Passenger> getAllFlights() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public
    ResponseEntity<Object> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        return ResponseEntity.ok(passenger);
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.savePassenger(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        passenger.setId(id);
        return passengerService.savePassenger(passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }
}
