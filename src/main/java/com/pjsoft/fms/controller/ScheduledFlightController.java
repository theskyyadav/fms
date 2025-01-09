package com.pjsoft.fms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.mapper.ScheduledFlightMapper;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;
import com.pjsoft.fms.pojo.response.ScheduleResponseDTO;
import com.pjsoft.fms.pojo.response.ScheduledFlightResponseDTO;
import com.pjsoft.fms.service.ScheduledFlightService;



@RestController
@RequestMapping("/api/scheduledFlights")
public class ScheduledFlightController {
    @Autowired
    private ScheduledFlightService scheduledFlightService;

    @Autowired
    private ScheduledFlightMapper scheduledFlightMapper;

//    @GetMapping
//    public List<ScheduledFlight> getAllSchedules() {
//        return scheduledFlightService.getAllScheduledFlights();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getScheduledFlightById(@PathVariable Long id) {
//    	ScheduledFlight scheduledFlight = scheduledFlightService.getScheduledFlightById(id);
//        return ResponseEntity.ok(scheduledFlight);
//    }
//
//    @PostMapping
//    public ScheduledFlight createScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
//        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
//    }
//
//    @PutMapping("/{id}")
//    public ScheduledFlight updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlight) {
//    	scheduledFlight.setId(id);
//        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteScheduledFlight(@PathVariable Long id) {
//    	scheduledFlightService.deleteScheduledFlight(id);
//    }

    @GetMapping
    public ResponseEntity<List<ScheduledFlightResponseDTO>> getAllScheduledFlights() {

        return ResponseEntity.ok(scheduledFlightService.getAllScheduledFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduledFlightResponseDTO> getScheduledFlightById(@PathVariable Long id) {
        ScheduledFlight scheduledFlight = scheduledFlightService.getScheduledFlightById(id);
        return ResponseEntity.ok(scheduledFlightMapper.entityToDtoMapper(scheduledFlight));
    }

    @PostMapping
    public ResponseEntity<ScheduledFlightResponseDTO> createScheduledFlight(@RequestBody ScheduledFlightDTO scheduledFlightDTO) {
        return new ResponseEntity<>(scheduledFlightService.saveScheduledFlight(scheduledFlightDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ScheduledFlightResponseDTO updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlightDTO scheduledFlightDTO) {
        scheduledFlightDTO.setId(id);
        return scheduledFlightService.saveScheduledFlight(scheduledFlightDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduledFlight(@PathVariable Long id) {
        scheduledFlightService.deleteScheduledFlight(id);
    }
}


