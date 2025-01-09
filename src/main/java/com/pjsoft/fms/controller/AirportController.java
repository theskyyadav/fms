package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.AirportDTO;
import com.pjsoft.fms.pojo.response.AirportResponseDTO;
import com.pjsoft.fms.service.AirportService;
import com.pjsoft.fms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public
class AirportController {
    @Autowired
    AirportService airportService;
    @GetMapping
    public
    List<AirportResponseDTO> getAllAirports() {
        return airportService.getAllAirports();
    }
    @GetMapping(path = "/{id}")
    public
    ResponseEntity<AirportResponseDTO> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }
    @PostMapping
    public Airport createAirport(@RequestBody AirportDTO airportDTO) {
        return airportService.saveAirport(airportDTO);
    }
    @PutMapping(path = "/{id}")
    public Airport updateAirport( @PathVariable Long id, @RequestBody AirportDTO airportDTO){
        airportDTO.setId(id);
        return airportService.saveAirport(airportDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBooking(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}
