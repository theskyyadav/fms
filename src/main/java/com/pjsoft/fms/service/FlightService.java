package com.pjsoft.fms.service;
import com.pjsoft.fms.exception.*;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.repository.FlightRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        logger.debug("inside getFlightById");
        return flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
//        if(flightRepository.findById(id).isEmpty()){
//            throw new ResourceNotFoundException("Flight not found with id: " + id);
//        }
        Flight flight=getFlightById(id);
        flightRepository.delete(flight);
    }
}
