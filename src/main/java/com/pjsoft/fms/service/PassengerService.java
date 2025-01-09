package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.repository.FlightRepository;
import com.pjsoft.fms.repository.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    public
    List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        logger.debug("inside getFlightById");
        return passengerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + id));
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
//        if(flightRepository.findById(id).isEmpty()){
//            throw new ResourceNotFoundException("Flight not found with id: " + id);
//        }
        Passenger passenger=getPassengerById(id);
        passengerRepository.delete(passenger);
    }
}
