package com.pjsoft.fms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.ScheduleMapper;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.pojo.request.PassengerDTO;
import com.pjsoft.fms.pojo.request.ScheduleDTO;
import com.pjsoft.fms.pojo.response.PassengerResponseDTO;
import com.pjsoft.fms.pojo.response.ScheduleResponseDTO;
import com.pjsoft.fms.repository.ScheduleRepository;


@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;
    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

//    public List<Schedule> getAllSchedules() {
//        return scheduleRepository.findAll();
//    }
//
//    public Schedule getScheduleById(Long id) {
//        logger.debug("inside getScheduleById");
//        return scheduleRepository.findById(id)
//        .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
//    }
//
//    public Schedule saveSchedule(Schedule schedule) {
//        return scheduleRepository.save(schedule);
//    }
//
//    public void deleteSchedule(Long id) {
//    	Schedule schedule = getScheduleById(id);
//    	scheduleRepository.deleteById(id);
//
//    }

    public List<ScheduleResponseDTO> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(scheduleMapper::entityToDtoMapper).collect(Collectors.toList());
    }

    public Schedule getScheduleById(Long id) {
        logger.debug("inside getScheduleById");
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
    }

    public ScheduleResponseDTO saveSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule= scheduleMapper.dtoToEntityMapper(scheduleDTO);
        scheduleRepository.save(schedule);
        return scheduleMapper.entityToDtoMapper(schedule);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = getScheduleById(id);
        scheduleRepository.deleteById(id);
    }
}





