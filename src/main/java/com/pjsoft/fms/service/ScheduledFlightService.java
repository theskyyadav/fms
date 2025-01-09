package com.pjsoft.fms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.ScheduledFlightMapper;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;
import com.pjsoft.fms.pojo.response.ScheduledFlightResponseDTO;
import com.pjsoft.fms.repository.ScheduledFlightRepository;

@Service
public class ScheduledFlightService {
    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;
    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    @Autowired
    private ScheduledFlightMapper scheduledFlightMapper;
//    public List<ScheduledFlight> getAllScheduledFlights() {
//        return scheduledFlightRepository.findAll();
//    }
//
//    public ScheduledFlight getScheduledFlightById(Long id) {
//        logger.debug("inside getScheduleById");
//        return scheduledFlightRepository.findById(id)
//        .orElseThrow(() -> new ResourceNotFoundException("ScheduledFlight not found with id: " + id));
//    }
//
//    public ScheduledFlight saveScheduledFlight(ScheduledFlight ScheduledFlight) {
//        return scheduledFlightRepository.save(ScheduledFlight);
//    }
//
//    public void deleteScheduledFlight(Long id) {
//    	ScheduledFlight scheduledFlight = getScheduledFlightById(id);
//    	scheduledFlightRepository.deleteById(id);
//
//    }

    public List<ScheduledFlightResponseDTO> getAllScheduledFlights() {
        return scheduledFlightRepository.findAll().stream().map(scheduledFlightMapper::entityToDtoMapper).collect(Collectors.toList());
    }

    public ScheduledFlight getScheduledFlightById(Long id) {
        logger.debug("inside getScheduledFlightById");
        return scheduledFlightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ScheduledFlight not found with id: " + id));
    }

    public ScheduledFlightResponseDTO saveScheduledFlight(ScheduledFlightDTO scheduledFlightDTO) {
        ScheduledFlight scheduledFlight= scheduledFlightMapper.dtoToEntityMapper(scheduledFlightDTO);
        scheduledFlightRepository.save(scheduledFlight);
        return scheduledFlightMapper.entityToDtoMapper(scheduledFlight);
    }

    public void deleteScheduledFlight(Long id) {
        ScheduledFlight scheduledFlight = getScheduledFlightById(id);
        scheduledFlightRepository.deleteById(id);
    }
}



